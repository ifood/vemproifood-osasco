//http://localhost:5000/users
import users from './users';

export default (app) => {
	app.use('/api/v1', users);
};