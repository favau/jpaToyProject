import 'bootstrap/dist/css/bootstrap.min.css'; // Bootstrap CSS
import "bootstrap-icons/font/bootstrap-icons.css";  // Bootstrap Icons
import '../assets/styles/common.css';   // Common CSS
import '../assets/styles/animation.css'; // 애니메이션 스타일 추가
import HomeMenuBox from './home/HomeMenuBox';
import HomeHeader from './home/HomeHeader';
import HomeFooter from './home/HomeFooter';

const Home = () => {


    return (
        <>
            <HomeHeader />
            <HomeMenuBox />
            <HomeFooter />
        </>
    );
};

export default Home;
