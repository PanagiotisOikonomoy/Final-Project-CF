import React, {
	useEffect,
	useState,
} from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import Search from "../common/Search";

//Author Panagiotis Oikonomou

const EmployeesView = () => {
	const [employees, setEmployees] = useState([]);
	const [search, setSearch] = useState("");

	useEffect(() => {
		loadEmployees();
	}, []);

	const loadEmployees = async () => {
		const result = await axios.get(
			"http://localhost:9192/employees",
			{
				validateStatus: () => {
					return true;
				},
			}
		);
		if (result.status === 302) {
			setEmployees(result.data);
		}
	};

	const handleDelete = async (id) => {
		await axios.delete(
			`http://localhost:9192/employees/delete/${id}`
		);
		loadEmployees();
	};

	return (
		<section>
			<Search
				search={search}
				setSearch={setSearch}
			/>
			<table className="table table-bordered table-hover shadow">
				<thead>
					<tr className="text-center">
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Job Title</th>
						<th colSpan="3">Actions</th>
					</tr>
				</thead>

				<tbody className="text-center">
					{employees
						.filter((e) =>
						e.firstname
							.toLowerCase()
							.includes(search)
					)
						.map((employee, index) => (
							<tr key={employee.id}>
								<th scope="row" key={index}>
									{index + 1}
								</th>
								<td>{employee.firstname}</td>
								<td>{employee.lastname}</td>
								<td>{employee.email}</td>
								<td>{employee.department}</td>
								<td className="mx-2">
									<Link
										to={`/employee-profile/${employee.id}`}
										className="btn btn-info">
										View
									</Link>
								</td>
								<td className="mx-2">
									<Link
										to={`/edit-employee/${employee.id}`}
										className="btn btn-warning">
										Edit
									</Link>
								</td>
								<td className="mx-2">
									<button
										className="btn btn-danger"
										onClick={() =>
											handleDelete(employee.id)
										}>
										Delete
									</button>
								</td>
							</tr>
						))}
				</tbody>
			</table>
		</section>
	);
};

export default EmployeesView;
