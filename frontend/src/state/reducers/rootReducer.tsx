import {combineReducers} from 'redux';
import {authorisationReducer} from './authorisationReducer';
import {mainReducer} from './mainReducer';

export const rootReducer = combineReducers({
  authorisationReducer,
  mainReducer,
});
