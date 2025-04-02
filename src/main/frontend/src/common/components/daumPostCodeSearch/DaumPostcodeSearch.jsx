import React, { useImperativeHandle, forwardRef, useCallback, useEffect } from 'react';

/**
 * @param {Object} props
 * @param {Array<{ childrenName: string, parentName: ref }>} onCompleteList - 저장할 데이터를 지정하는 props
 * @param {{        
 *      bgColor:string, //바탕 배경색
 *      searchBgColor: string, //검색창 배경색
 *      contentBgColor: string, //본문 배경색(검색결과,결과없음,첫화면,검색서제스트)
 *      pageBgColor: string, //페이지 배경색
 *      textColor: string, //기본 글자색
 *      queryTextColor: string //검색창 글자색
 *      postcodeTextColor: string, //우편번호 글자색
 *      emphTextColor: string, //강조 글자색
 *      outlineColor: string, //테두리
 *      }} props.themeObj - 색상 테마를 지정하는 props
 * 
 * @param {React.Ref} ref - React ref, postcode에 사용
 */

const DaumPostcodeSearch = forwardRef((props, ref) => {

    const loadPostcode = useCallback(() => { // api 설정
        if (window.daum && window.daum.Postcode) {
            return;
        }
        const script = document.createElement('script');
        script.src = '//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js';//다음 우편번호 찾기 api script src url
        script.async = true;
        document.body.appendChild(script);

        return () => {
            document.body.removeChild(script);
        };
    }, []);

    useEffect(() => {
        const cleanup = loadPostcode();
        return cleanup;
    }, [loadPostcode]);

    const openPostcode = useCallback(() => {
        if (!window.daum || !window.daum.Postcode) {
            console.error('Daum Postcode script not loaded');
            return;
        }

        new window.daum.Postcode({
            //입력된 테마가 있으면 해당 테마를 적용. 없으면 기본 테마 적용
            theme: (props.themeObj ? props.themeObj :   //테마를 지정
                {
                    bgColor: "#ECECEC", //바탕 배경색
                    searchBgColor: "#0D6EFD", //검색창 배경색
                    pageBgColor: "#FFFFFF", //페이지 배경색
                    textColor: "#0D6EFD", //기본 글자색
                    queryTextColor: "#FFFFFF" //검색창 글자색
                }),
            //결과 반환 콜백함수
            oncomplete: function (results) {
                //배열 객체 형태로 입력받아 저장. [{저장할변수,postcode의변수}]
                if (props.onCompleteList && Array.isArray(props.onCompleteList)) {
                    props.onCompleteList.forEach(item => {
                        if (item.childrenName && results[item.childrenName]) {
                            if (item.zipCdRef && item.zipCdRef.current) {
                                return item.zipCdRef.current.value = results[item.childrenName];
                            } else if (item.parentName && item.parentName.current) {
                                return item.parentName.current.value = results[item.childrenName];
                            }
                        }
                    });
                }
                if (props.onComplete) {
                    return props.onComplete(results);
                }
            },
            onresize: function (data) {
            },
            onclose: function (data) {
            },
            onsearch: function (data) {
            },
            width: function (data) {
            },
            height: function (data) {
            },
            animation: function (data) {
            },
            focusInput: function (data) {
            },
            autoMappingRoad: function (data) {
            },
            autoMappingJibun: function (data) {
            },
            shorthand: function (data) {
            },
            pleaseReadGuide: function (data) {
            },
            pleaseReadGuideTimer: function (data) {
            },
            maxSuggestItems: function (data) {
            },
            showMoreHName: function (data) {
            },
            hideMapBtn: function (data) {
            },
            hideEngBtn: function (data) {
            },
            alwaysShowEngAddr: function (data) {
            },
            submitMode: function (data) {
            },
            useBannerLink: function (data) {
            }
        }).open();
    }, [props]);

    useImperativeHandle(ref, () => ({
        openPostcode,
    }));

    return null;
});

export default DaumPostcodeSearch;