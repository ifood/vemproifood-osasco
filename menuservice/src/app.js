import express from 'express';
import bodyParser from 'body-parser';
import cors from 'cors';
import routes from './routes';


const app = express();

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(cors());

routes(app);

app.listen(4000, () => console.log('Express server started...'));