import {EventType} from '../store';

export const SET_AUTHORISATION_STATUS = 'SET_AUTHORISATION_STATUS';

interface SetAuthorisationStatus {
  type: typeof SET_AUTHORISATION_STATUS;
  payload: boolean;
}
// Actions, connected with Authorisation Page
export type AuthorisationAction = SetAuthorisationStatus;

export const SET_EVENTS = 'SET_EVENTS';

interface SetEvents {
  type: typeof SET_EVENTS;
  payload: EventType[];
}

// Actions, connected with Main Page
export type MainAction = SetEvents;
