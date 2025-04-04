import 'bootstrap/dist/css/bootstrap.min.css';
import "bootstrap-icons/font/bootstrap-icons.css";

const Footer = () => {

	const openYoutubeSite = () => {
		window.open('https://www.youtube.com/@%EC%9C%A0%ED%97%B7', '_blank');
	};

	const openGitHubSite = () => {
		window.open('https://github.com/favau', '_blank');
	};

	const openReactSite = () => {
		window.open('https://ko.react.dev/', '_blank');
	};

	return (
		<footer className="text-white py-4 mt-5">
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
						<p className="small">
							<i class="bi bi-file-earmark-lock-fill me-2"></i><a href="/#" className=" text-decoration-none">파일 관리</a><br />
							<i class="bi bi-file-earmark-play-fill me-2"></i><a href="/#" className="text-decoration-none">영상 목록</a><br />
							<i class="bi bi-youtube me-2"></i><span onClick={openYoutubeSite} style={{ cursor: 'pointer' }}>Youtube</span><br />
							<i class="bi bi bi-github me-2"></i><span onClick={openGitHubSite} style={{ cursor: 'pointer' }}>GitHub</span><br />
							<i class="bi bi-file-earmark-play-fill me-2"></i><a href="/#" className=" text-decoration-none">영상 목록</a><br />
						</p>
					</div>

					<div className="col-md-4">
						<h5 className="fw-bold">연락처</h5>
						<p className="small">
							<i className="bi bi-geo-alt-fill me-2"></i>서울특별시 중랑구 상봉동 ***로 123<br />
							<a href="tel:02-***-****">
								<i className="bi bi-telephone-fill me-2"></i>
								02-***-****
							</a><br />
							<a href="mailto:kindkindred1202@gmail.com">
								<i className="bi bi-envelope-fill me-2"></i>
								kindkindred1202@gmail.com
							</a>

						</p>
					</div>
				</div>
				
				<hr className="border-light" />
				<div className="text-center">
					<p className="mb-0">© 2025 fav. All Rights Reserved.</p>
					<span onClick={openReactSite} style={{ cursor: 'pointer', fontWeight: 'bold', display: 'inline-flex', alignItems: 'center', gap: '0.3rem' }}>
						This page is powered by React ⚛️
					</span>
				</div>
			</div>
		</footer >
	);
}

export default Footer;
