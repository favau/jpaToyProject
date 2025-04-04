import 'bootstrap/dist/css/bootstrap.min.css';
import "bootstrap-icons/font/bootstrap-icons.css";

const HomeFooter = () => {
	return (
		<footer className="bg-white text-white py-4 mt-5 border-top border-1 border-dark">
			<div className="container">
				<div className="row">
					<div className="col-md-4">
						<h5 className="fw-bold">소개</h5>
						<p className="small">
							소개 <br />
							소개
						</p>
					</div>

					<div className="col-md-4">
						<h5 className="fw-bold">빠른 링크</h5>
						<ul className="list-unstyled">
							<li><a href="#" className="text-white text-decoration-none">홈</a></li>
							<li><a href="#" className="text-white text-decoration-none">서비스</a></li>
							<li><a href="#" className="text-white text-decoration-none">지원</a></li>
							<li><a href="#" className="text-white text-decoration-none">문의</a></li>
						</ul>
					</div>

					<div className="col-md-4">
						<h5 className="fw-bold">연락처</h5>
						<p className="small">
							<i className="bi bi-geo-alt-fill me-2"></i>서울특별시 중랑구 상봉동 ***로 123<br />
							<i className="bi bi-telephone-fill me-2"></i>02-***-****<br />
							<i className="bi bi-envelope-fill me-2"></i>kindkindred1202@gmail.com
						</p>
					</div>
				</div>

				<hr className="border-light" />

				<div className="text-center">
					<p className="mb-0">© 2025 fav. All Rights Reserved.</p>
				</div>
			</div>
		</footer>
	);
}

export default HomeFooter;
