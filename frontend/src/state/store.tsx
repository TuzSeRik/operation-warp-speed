import {createStore, applyMiddleware} from 'redux';
import {composeWithDevTools} from 'redux-devtools-extension';
import thunk from 'redux-thunk';
import {rootReducer} from './reducers/rootReducer';

export type EventType = {
  id: string;
  userId: string;
  description: string;
  startTimeString: string;
  attendees: string[];
  location: string;
};

export type StoreType = {
  authorisationReducer: {
    isAuthorised: boolean;
  };
  mainReducer: {
    events: EventType[];
  };
};

export const store = createStore(
  rootReducer,
  composeWithDevTools(applyMiddleware(thunk))
);
