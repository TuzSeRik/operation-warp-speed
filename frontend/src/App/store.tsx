import {combineReducers} from 'redux';
import {configureStore} from '@reduxjs/toolkit';
import {redirectionReducer} from '../authorisationPage/Redirection/redirectionSlice';
import {eventListReducer} from '../mainPage/EventList/eventListSlice';

const reducer = combineReducers({redirectionReducer, eventListReducer});

export const store = configureStore({reducer});
export type StoreType = ReturnType<typeof store.getState>;
