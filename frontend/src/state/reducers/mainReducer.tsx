import {MainAction, SET_EVENTS} from '../actions/actionTypes';

export function mainReducer(state = {}, action: MainAction) {
  switch (action.type) {
    case SET_EVENTS:
      return {
        ...state,
        events: action.payload,
      };
    default:
      return state;
  }
}
