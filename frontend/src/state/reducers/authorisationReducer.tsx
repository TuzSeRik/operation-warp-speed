import {
  AuthorisationAction,
  SET_AUTHORISATION_STATUS,
} from '../actions/actionTypes';

export function authorisationReducer(state = {}, action: AuthorisationAction) {
  switch (action.type) {
    case SET_AUTHORISATION_STATUS:
      return {
        ...state,
        isAuthorised: action.payload,
      };
    default:
      return state;
  }
}
