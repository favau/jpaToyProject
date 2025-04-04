import { api } from "api/api";
import { API_ENDPOINTS } from "config/apiConfig";
import { useEffect, useRef, useState } from "react";
import { Button, Col, Row } from "react-bootstrap";
import { CSSTransition } from "react-transition-group";

const HomeMenuBox = () => {

    return (
        <>
            <HomeMenuBoxFunctionList />
            <HomeMenuBoxProject1 />
        </>
    )
}

export default HomeMenuBox;

const HomeMenuBoxFunctionList = () => {
    const [completeState, setcompleteState] = useState(false);
    const [incompleteState, setIncompleteState] = useState(false);
    const nodeRef = useRef(null); // CSSTransition에서 사용할 ref

    useEffect(() => {
        // 전체 기능 목록 통신
        fetchIncompleteFunctionInCode();
        // fetchModelCaseData();
        // fetchVoCaseData();
    }, [])

    const fetchIncompleteFunctionInCode = async () => {
        const requestData = {

        }
        const response = await api.get(API_ENDPOINTS.project1.code.read, requestData);
        if (response && response.resultList) {
            console.log("구현중 기능 목록 응답:", response.resultList);
        }
    }
    const fetchModelCaseData = async () => {
        try {
            const response = await api.get("/project1/mybatisExample/mybatisModelCase/read", {});
            console.log("Model Case GET 응답:", response.data);
        } catch (error) { }
    }

    const fetchVoCaseData = async () => {
        try {
            const response = await api.get("/project1/mybatisExample/mybatisVoCase/read", {});
            console.log("Vo Case GET 응답:", response.data);
        } catch (error) { }
    }

    const handleCompleteFunctionClick = (e) => {
        e.preventDefault();
        setcompleteState(!completeState);
    }

    const handleIncompleteFunctionClick = (e) => {
        e.preventDefault();
        setIncompleteState(!incompleteState);
    }

    const handleCloseButtonClick = () => {
        setcompleteState(false);
        setIncompleteState(false);
    }

    return (
        <div className="container mt-5 mb-5">
            <div className="p-4 rounded-4" style={{ backgroundColor: "#0075d2", color: "#fff", textAlign: "left" }}>
                {!completeState && !incompleteState && (
                    <>
                        <div className="home-menu-box-title-border d-flex justify-content-between align-items-center mb-3">
                            <div className="d-flex align-items-center gap-3">
                                <i className="bi bi-heart-arrow fs-2 text-white"></i>
                                <h2 className="fw-bold mb-0" style={{ color: "#fff" }}>구현 완료 기능</h2>
                            </div>
                            <Button variant="outline-light">
                                <i className="bi bi-arrow-right"></i> 바로가기
                            </Button>
                        </div>
                        <Row>
                            <Col xs={12} lg={6} className="home-menu-box-content-border mb-3 mb-lg-0">
                                <h3 className="fw-bold mb-2" style={{ color: "#fff" }}>구현 완료 기능</h3>
                                <div className="d-flex justify-content-between align-items-center">
                                    <p style={{ color: "#fff" }}>구현 완료 기능 목록 전체보기</p>
                                    <Button variant="outline-light" onClick={handleCompleteFunctionClick}>
                                        <i className="bi bi-arrow-down"></i>
                                    </Button>
                                </div>
                            </Col>

                            <Col xs={12} lg={6}>
                                <h3 className="fw-bold mb-2" style={{ color: "#fff" }}>구현중 기능</h3>
                                <div className="d-flex justify-content-between align-items-center">
                                    <p style={{ color: "#fff" }}>구현중 기능 목록 전체보기</p>
                                    <Button variant="outline-light" onClick={handleIncompleteFunctionClick}>
                                        <i className="bi bi-arrow-down"></i>
                                    </Button>
                                </div>

                            </Col>
                        </Row>
                    </>
                )}
                <CSSTransition
                    in={completeState || incompleteState}
                    timeout={300}
                    classNames="slide"
                    unmountOnExit
                    nodeRef={nodeRef}
                >
                    <div ref={nodeRef}>
                        <div className="d-flex align-items-center gap-3 w-100">
                            <h2 className="fw-bold mb-0" style={{ color: "#fff" }}>
                                {completeState && "구현 완료 기능"}
                                {incompleteState && "구현중 기능"}
                            </h2>
                            <div className="d-flex justify-content-end ms-auto"> {/* ✨ X버튼을 오른쪽으로 밀어줌 */}
                                <a href="#" className="btn_close" onClick={handleCloseButtonClick}>
                                    <span className="hidden">닫기</span>
                                </a>
                            </div>
                        </div>

                        {/* state에 따라 해당 state에 맞는 array를 넣어주게 변경 필요 */}
                        {Array.from({ length: 9 }).map((_, i) => (
                            <p key={i} style={{ color: "#fff", marginTop: "10px" }}>Jstree {i + 1}</p>
                        ))}
                    </div>
                </CSSTransition>
            </div>
        </div>
    );
}

const HomeMenuBoxProject1 = () => {

    return (
        <>
        </>
    )
}