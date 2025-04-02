import { createBrowserRouter, RouterProvider } from "react-router-dom";

import Layout from "./common/components/layouts/Layout";
import Home from "./pages/Home";
import JooqExample from "pages/project1/jooqExample/JooqExample";
import JpaExample from "pages/project1/jpaExample/JpaExample";
import MybatisExample from "pages/project1/mybatisExample/MybatisExample";
import QuerydslExample from "pages/project1/querydslExample/QuerydslExample";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Layout />,
        children: [
            {
                path: "/",
                element: <Home />,
            },
            {
                path: "/querydslExample",
                element: <QuerydslExample />,
            },
            {
                path: "/project1/mybatisExample",
                element: <MybatisExample />,
            },
            {
                path: "/jpaExample",
                element: <JpaExample />,
            },
            {
                path: "/jooqExample",
                element: <JooqExample />,
            },
        ],
    },
]);

function App() {
    return (
        <div className="App">
            <RouterProvider router={router} />
        </div>
    );
}

export default App;