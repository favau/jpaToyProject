import { Outlet, useLocation } from "react-router-dom";
import Footer from "./Footer";
import Header from "./Header";

const Layout = () => {
	const location = useLocation();
	const isHome = location.pathname === "/"; // 홈 경로 확인

	return (
		<>
			{!isHome && <Header />}
			<main>
				<Outlet />
			</main>
			{!isHome && <Footer />}
		</>
	);
}

export default Layout;
