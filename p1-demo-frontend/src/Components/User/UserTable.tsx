import { Container, Table } from "react-bootstrap"

export const UserTable:React.FC = () => {



    return(
        <Container>
            
            <h3>Users: </h3>

            <Table className="table-dark table-hover table-striped">
                <thead>
                    <tr>
                        <th>User Id</th>
                        <th>Username</th>
                        <th>Role</th>
                    </tr>
                </thead>
                <tbody>
                    
                </tbody>
            </Table>

        </Container>
    )

}