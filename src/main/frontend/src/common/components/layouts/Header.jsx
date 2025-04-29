import logo from "../../../assets/images/fav_logo.png";
import { Image } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

const Header = () => {
    const navigate = useNavigate();

    const handleClick = (e) => {
        e.preventDefault();
        navigate("/");
    };

    return (
        <header>
            <div className='d-flex justify-content-start align-items-center p-1 w-100 gap-4' style={{ backgroundColor: 'gray' }}>
                <div className='d-flex p-2 h-100 align-items-center gap-4 w-auto'>
                    <Image
                        src={logo}
                        alt="Logo"
                        roundedCircle
                        onClick={handleClick}
                        className='bg-black'
                        style={{
                            width: "5rem",
                            height: "5rem",
                            objectFit: "contain",
                            cursor: "pointer"
                        }}
                    />
                    <h1 className="fw-bold mb-0" style={{ color: "#fff" }}>
                        <a
                            href="#"
                            onClick={handleClick}
                            style={{
                                color: "inherit",
                                textDecoration: "none"
                            }}
                        >
                            jpaToyProject 웹 사이트
                        </a>
                    </h1>
                </div>
                <div>
                    버튼
                </div>
            </div>
        </header>
    );
}

export default Header;
