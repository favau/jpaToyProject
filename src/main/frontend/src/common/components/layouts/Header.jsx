import { useState } from "react";

const Header = () => {
    const [isSelected, setIsSelected] = useState(true); // isSelected 변수 선언

    return (
        <header>
            <h1>My Application</h1>
            <div className="quick_link">
                {
                    isSelected ? (
                        <>
                            <a href="#" className="on" title="A 바로가기 선택됨">
                                <span>A</span>
                            </a>
                            <a href="#" title="B 바로가기">
                                <span>B</span>
                            </a>
                        </>
                    ) : (
                        <>
                            <a href="#" className="on" title="B 바로가기">
                                <span>A</span>
                            </a>
                            <a href="#" title="B 바로가기 선택됨">
                                <span>B</span>
                            </a>
                        </>
                    )
                }
            </div>
        </header>
    );
}

export default Header;
