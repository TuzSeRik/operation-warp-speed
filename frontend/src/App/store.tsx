import {combineReducers} from 'redux';
import {configureStore} from '@reduxjs/toolkit';
import {redirectionReducer} from '../authorisationPage/Redirection/redirectionSlice';
import {eventListReducer} from '../mainPage/EventList/eventListSlice';
import {addEventButtonReducer} from '../mainPage/AddEventButton/addEventButtonSlice';
import {eventAdderReducer} from '../mainPage/EventAdder/eventAdderSlice';

const reducer = combineReducers({
  redirectionReducer,
  eventListReducer,
  addEventButtonReducer,
  eventAdderReducer,
});

export const store = configureStore({reducer});
export type StoreType = ReturnType<typeof store.getState>;
