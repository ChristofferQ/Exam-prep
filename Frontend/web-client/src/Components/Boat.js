import React, { useState, useEffect } from "react";
import facade from "../ApiFacade";

const Boat = () => {
    const [boatList, setBoatList] = useState([]);
    useEffect(() => {
        facade.fetchData("boat")
            .then(data => {
                setBoatList(data);
            })
    }, []);

    const [query, setQuery] = useState("");

    return (
        <div className="container mt-5">
            <h2>List Of Boats</h2>
            <table className="table mt-4">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Brand</th>
                    <th>Make</th>
                    <th>Name</th>
                    <th>Image</th>
                </tr>
                </thead>
                <tbody>
                {
                    boatList.map((boat, index) => (
                        <tr>
                            <td>{boat.id}</td>
                            <td>{boat.brand}</td>
                            <td>{boat.make}</td>
                            <td>{boat.name}</td>
                            <td>{boat.image}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    )
}

export default Boat;