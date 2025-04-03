// api.js
import axios from "axios";

// axios 통신 스크립트

// Axios 기본 설정
const instance = axios.create({
  baseURL: "",
  timeout: 5000, // 5초 타임아웃
  headers: {
    "Content-Type": "application/json",
  },
});

// 토큰 추가
export const setAuthToken = (token) => {
  instance.defaults.headers.common["Authorization"] = `Bearer ${token}`;
};

// 요청/응답 인터셉터
instance.interceptors.request.use(
  config => {
    console.log("요청 전:", config);
    return config;
  },
  error => {
    return Promise.reject(error);
  }
);

instance.interceptors.response.use(
  response => response,
  error => {
    console.error("응답 에러:", error);
    return Promise.reject(error);
  }
);

// 공통 API 함수
export const api = {
  get: (url, params) => instance.get(url, { params }),
  post: (url, data) => instance.post(url, data),
  put: (url, data) => instance.put(url, data),
  delete: (url, params) => instance.delete(url, { params }),
};
