import axios from 'axios'
import csv from 'csvtojson'

export default async (req, res,) => {
	
	try {
		/**Find a user by ID*/
		const cidade = req.params

		const dish = await  axios.get(`https://6h3yzrpuwj.execute-api.sa-east-1.amazonaws.com/v1/recommend?city=${cidade}`) 
		
		
		const csvFilePath="/home/osboxes/Documents/orders8.csv"

		const jsonArray = await csv().fromFile(csvFilePath)

		const result = jsonArray[0]

		return res.status(200).send({ dica: jsonArray });
	} catch (err) {
		return res.status(500).json({ error: err.message });
	}
};