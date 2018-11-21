import { Router } from 'express';

import findOne from './find-by-id';

const router = Router();

/**Find one by ID */

//GET /users/5bac1f4980701043b4bb0b80
router.get('/dish/:cidade', findOne);


export default router;