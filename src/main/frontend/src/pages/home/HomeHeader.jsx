import logo from "../../assets/images/fav_logo.png";
import { Image } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

const HomeHeader = () => {
    const navigate = useNavigate();

    const handleClick = (e) => {
        e.preventDefault();
        navigate("/");
    };

    return (
        <header>
            <div className='d-flex justify-content-start align-items-center p-1 w-100 gap-4' style={{ backgroundColor: 'white' }}>
                <div className='d-flex p-2 h-100 align-items-center gap-4 w-auto'>
                    <Image
                        src={logo}
                        alt="Logo"
                        roundedCircle
                        onClick={handleClick}
                        className='bg-black'
                        style={{
                            width: "3rem",
                            height: "3rem",
                            objectFit: "contain",
                            cursor: "pointer"
                        }}
                    />
                    <h2 className="fw-bold mb-0" style={{ color: "#fff" }}>
                        <a
                            href="#"
                            onClick={handleClick}
                            style={{
                                color: "black",
                                textDecoration: "none"
                            }}
                        >
                            jpaToyProject 웹 사이트
                        </a>
                    </h2>
                </div>
                <div>
                    {/* 헤더 버튼 구역 */}
                </div>
            </div>
        </header>
    );
}

export default HomeHeader;
