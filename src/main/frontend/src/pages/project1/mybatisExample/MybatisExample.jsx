import { useEffect } from "react";

const MybatisExample = () => {
    useEffect(() => {
        // Fetch data from the server
        fetch("/project1/mybatisExample/read")
            .then(response => response.json())
            .then(data => {
                // Handle the data received from the server
                console.log(data);
            })
            .catch(error => {
                // Handle any errors that occurred during the fetch
                console.error("Error fetching data:", error);
            });
    }, []);

    return (
        <div>
            <h1>MyBatis Example</h1>
            <p>This is an example of using MyBatis with Java.</p>
        </div>
    );
}

export default MybatisExample;
