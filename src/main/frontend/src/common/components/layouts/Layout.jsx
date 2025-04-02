import { Outlet } from "react-router-dom";
import Footer from "./Footer";
import Header from "./Header";

/**
 * Layout Component
 *  
 * @returns {JSX.Element} Layout 컴포넌트 JSX
 */
const Layout = () => {
	return (
		<>
			<Header />
			<main>
				<Outlet />
			</main>
			<Footer />
		</>
	);
}

export default Layout;