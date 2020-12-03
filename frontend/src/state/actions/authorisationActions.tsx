import {SET_AUTHORISATION_STATUS} from './actionTypes';
import {useSelector} from 'react-redux';
import {StoreType} from '../store';

export function proceedAuthorisationResponse(res: string) {
  if (res === '?status=ok') {
    return {
      type: SET_AUTHORISATION_STATUS,
      payload: true,
    };
  } else {
    return {
      type: SET_AUTHORISATION_STATUS,
      payload: useSelector(
        (state: StoreType) => state.authorisationReducer.isAuthorised
      ),
    };
  }
}
