import React, { forwardRef, useRef, useImperativeHandle, useEffect, useId, useState } from 'react';
import $ from 'jquery';
import 'jstree';
import '../../../assets/styles/jstree.css';
import { typesObject } from 'config/JstreePluginsConfig';

/**
 * JstreeComponent: jstree를 이용하여 데이터를 계층 구조로 표시하는 컴포넌트
 * ref.value() 또는 jstreeResults를 통해 선택된 노드의 정보를 가져올 수 있음
 * ref.value()는 노드를 클릭 했을 때, jstreeResults는 더블 클릭 또는 confirm 버튼 클릭 시 호출됨
 * 
 *
 * @param {Object} props - 전달되는 모든 속성
 * @param {Array} props.plugins - jstree 플러그인 설정
 * @param {function} props.treeDataNodes - 트리에 사용될 데이터를 리턴하는 함수
 * @param {function} props.jstreeResults - 선택된 노드 결과 반환 함수
 * @param {function} props.onClose - 모달 닫기 함수
 * @param {Boolean} props.showRootPath - input창에 루트 노드를 경로에 포함하여 표시할 지 여부. 기본값 false
 * @param {React.Ref} ref - 외부 참조용 ref (value(), focus())
 * 
 * @returns {JSX.Element} 입력 필드와 라벨을 포함한 JSX
 */

const JstreeComponent = forwardRef(({
  plugins = {
    types: false,    //노드의 타입 설정
    themes: false,   //테마 설정
    search: false,   //검색기능 제공
    sort: false,    //노드 정렬
    state: false,   //마지막 상태를 저장하고 복원
    contextmenu: false, //노드 우클릭 시 컨텍스트 메뉴 표시
    dnd: false,  //노드를 드래그 앤 드롭으로 이동
    checkbox: false, // 체크박스 제공
    unique: false, //같은 부모 아래에서 고유한 ID 유지
    conditional: false, //특정 조건을 만족할 때만 선택 가능
    massload: false, //많은 양의 데이터를 동적 로드
    grid: false, //그리드 모양으로 트리 표시
    hotkeys: false, //단축키 기능 제공
    sort: false, //정렬 기준 설정
    wholerow: false, //노드 클릭할 때 라인 전체 클릭
    changed: false, //노드 선택 상태 변경 시 이벤트 발생
    crrm: false, //생성, 이름 변경, 제거 기능
  },
  treeDataNodes,
  jstreeResults,
  onClose,
  showRootPath = false,
  // searchText,
  ...props
}, ref) => {
  const [searchText, setSearchText] = useState(''); // 검색어를 state로 관리
  const treeRef = useRef(null); // jstree를 초기화할 DOM 요소에 대한 참조
  const treeId = useId(); // 고유한 ID 생성 (jstree의 상태 저장을 위한 키로 사용)

  // 선택된 트리 데이터 반환
  useImperativeHandle(ref, () => ({
    value: () => {
      const selectedNodes = $(treeRef.current).jstree('get_selected', true);
      return selectedNodes.map(node => node.original);
    }
  }));

  // true인 플러그인만 배열로 생성
  const pluginsArray = Object.entries(plugins)
    .filter(([_, isEnabled]) => isEnabled)
    .map(([key]) => key);

  const initTreeView = async (treeData) => {
    const data = { data: treeData };

    // jstree 초기화 및 이벤트 바인딩을 분리
    const $tree = $(treeRef.current);

    // jstree가 이미 초기화되어 있는지 확인
    if ($tree.jstree(true)) {
      // 이미 초기화된 경우, 데이터만 교체하고 상태 유지
      $tree.jstree(true).settings.core.data = treeData;
      $tree.jstree(true).refresh();
    } else {
      // 초기화되지 않은 경우, 새로 생성
      $tree.jstree({
        core: data,
        plugins: pluginsArray,
        types: typesObject,
        state: {
          key: treeId,  // 상태 저장을 위한 키
          ttl: 60 * 60 * 1000  // 상태 저장 시간 (1시간)
        },
        ...props,
      });

      $tree.on('dblclick.jstree', function () {
        const instance = $tree.jstree(true);
        const selectedNode = instance.get_selected(true);
        jstreeResults(selectedNode);  // 선택된 노드 결과 함수 호출
      });

      $tree.on('select_node.jstree', function () {  // 체크박스 선택 시
        // 이벤트 필요 시 로직 구현현
        // const instance = $tree.jstree(true);
        // const selectedNode = instance.get_selected(true);
        // jstreeResults(selectedNode);  // 선택된 노드 결과 함수 호출
      });

      $tree.on('deselect_node.jstree', function () {  // 체크박스 해제 시
        const instance = $tree.jstree(true);
        const selectedNode = instance.get_selected(true);
        jstreeResults(selectedNode);  // 선택된 노드 결과 함수 호출
      });
    };
  }

  // treeDataNodes가 변경될 때마다 트리 갱신
  // jstree는 데이터가 변경되더라도 자동으로 이를 반영하지 않기 때문에,
  // 데이터가 변경될 때마다 jstree를 새로 초기화하거나 기존 트리 데이터를 갱신 필요
  useEffect(() => {
    const fetchData = async () => {
      let dataFromNode;
      // treeDataNodes가 함수인지 배열인지 확인하고 처리
      if (typeof treeDataNodes === 'function') {
        // treeDataNodes가 함수인 경우 실행하여 데이터를 가져옴
        dataFromNode = await treeDataNodes();
      } else if (Array.isArray(treeDataNodes)) {
        // treeDataNodes가 배열인 경우 바로 사용
        dataFromNode = treeDataNodes;
      } else {
        // 배열도 아니고 함수도 아니라면 빈 배열을 사용
        dataFromNode = [];
      }

      initTreeView(dataFromNode);  // 데이터 갱신
    };

    fetchData();
  }, [treeDataNodes]);  // treeDataNodes가 변경될 때마다 실행

  // 트리에서 노드를 클릭했을 때 선택된 노드 해제
  const resetSelectedNodes = (e) => {
    // treeRef 내부 클릭 시 이벤트 전파 막기
    if (treeRef.current && treeRef.current.contains(e.target)) return;

    // jstree의 deselect_all 호출
    $(treeRef.current).jstree(true).deselect_all();
  }

  ////////////////// plugin : search ////////////////
  // 기본 search plugin은 .search() 메서드를 이용하여 실시간 검색을 지원
  // 검색 버튼이 존재하여 커스텀 검색 기능으로 구현

  useEffect(() => {
    // 검색어가 변경되었을 때 트리에서 검색을 실행
    if (searchText) {
      $(treeRef.current).jstree(true).search(searchText);
    }
  }, [searchText]);  // 검색어가 변경될 때마다 반영

  // 검색어 입력 시 엔터키 이벤트 처리
  const handleKeyPress = (e) => {
    if (e.key === 'Enter') {
      e.preventDefault();
      setSearchText(e.target.value); // 엔터 눌렀을 때 검색어 적용
    }
  };

  // 검색 버튼 클릭 시 검색어 적용
  const handleSearchClick = (e) => {
    e.preventDefault();
    const input = document.getElementById('searchDataInput');
    setSearchText(input.value); // 버튼 눌렀을 때 검색어 적용
  };

  ////////////////// plugin : search ////////////////

  return (
    <>
      {plugins.search &&
        <div className="input-group mt-2 mb-2">
          <input
            type="text"
            className="form-control border-black"
            id="searchDataInput"
            placeholder='검색어를 입력하세요'
            onKeyDown={handleKeyPress}
          />
          <button
            type="submit"
            className="btn btn-primary"
            id="searchData"
            onClick={handleSearchClick}
          >
            검색
          </button>
        </div>
      }
      <div
        className="border border-black border-1 rounded mt-0"
        style={{ height: '30rem', overflowY: 'auto' }}
      >
        <div
          id='jstreeContent'
          className="h-100"
          onClick={resetSelectedNodes}
        >
          <div ref={treeRef} />
        </div>
      </div>
    </>
  );
});

export default JstreeComponent;
