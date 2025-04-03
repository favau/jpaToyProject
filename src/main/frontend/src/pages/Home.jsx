import 'bootstrap/dist/css/bootstrap.min.css'; // Bootstrap CSS
import "bootstrap-icons/font/bootstrap-icons.css";  // Bootstrap Icons
import '../assets/styles/common.css';   // Common CSS
import { Row, Col, Button, Image } from "react-bootstrap";
import logo from "../assets/images/orange-4547207_1920.png"; // 이미지 불러오기
import { useEffect } from 'react';
import { api } from 'api/api';

const Home = () => {

    useEffect(() => {
        fetchModelCaseData();
        fetchVoCaseData();
    }, [])

    const fetchModelCaseData = async () => {
        try {
            const response = await api.get("/project1/mybatisExample/mybatisModelCase/read", {});
            console.log("Model Case GET 응답:", response.data);
        } catch (error) {
            // console.error("GET 에러:", error);
        }
    }

    const fetchVoCaseData = async () => {
        try {
            const response = await api.get("/project1/mybatisExample/mybatisVoCase/read", {});
            console.log("Vo Case GET 응답:", response.data);
        } catch (error) {
            // console.error("GET 에러:", error);
        }
    }

    const handleCompleteFunctionClick = (e) => {
        e.preventDefault();
        // Handle the click event for the complete function button
        console.log("Complete Function Clicked!");
        // Add your logic here, e.g., redirect to another page or show a modal
    }

    const handleIncompleteFunctionClick = (e) => {
        e.preventDefault();
        // Handle the click event for the incomplete function button
        console.log("Incomplete Function Clicked!");
        // Add your logic here, e.g., redirect to another page or show a modal
    }

    return (
        <div className="container mt-5">
            <div className="p-4 rounded-4" style={{ backgroundColor: "#0075d2", color: "#fff", textAlign: "left" }}>
                <div className="d-flex justify-content-between align-items-center mb-3">
                    <Image src={logo} alt="Logo" roundedCircle style={{ width: "60px", height: "60px", objectFit: "contain" }} />
                    <Button variant="outline-light">
                        <i className="bi bi-arrow-right"></i> 바로가기
                    </Button>
                </div>

                <Row>
                    <Col className="border-end">
                        <h3 className="fw-bold mb-2" style={{ color: "#fff" }}>구현 완료 기능</h3>
                        <div className="d-flex justify-content-between align-items-center">
                            <p style={{ color: "#fff" }}>구현 완료 기능 목록 전체보기</p>
                            <Button variant="outline-light" onClick={handleCompleteFunctionClick}>
                                <i className="bi bi-arrow-right"></i>
                            </Button>
                        </div>
                    </Col>

                    <Col>
                        <h3 className="fw-bold mb-2" style={{ color: "#fff" }}>구현중 기능</h3>
                        <div className="d-flex justify-content-between align-items-center">
                            <p style={{ color: "#fff" }}>구현중 기능 목록 전체보기</p>
                            <Button variant="outline-light" onClick={handleIncompleteFunctionClick}>
                                <i className="bi bi-arrow-right"></i>
                            </Button>
                        </div>
                        <p style={{ color: "#fff" }}>Jstree</p>
                    </Col>
                </Row>
            </div>
        </div>
    );
};

export default Home;
