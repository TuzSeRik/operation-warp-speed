import React from 'react';
import {useDispatch} from 'react-redux';
import {useHistory} from 'react-router-dom';
import {proceedAuthorisationResponse} from '../../state/actions/authorisationActions';

export function Redirection() {
  const dispatch = useDispatch();
  const history = useHistory();
  dispatch(proceedAuthorisationResponse(window.location.search));
  history.push('/main');

  return (
    <div>
      If you see this message, try to reload page, or,
      <a
        onClick={event => {
          event.preventDefault();
          window.location.reload();
        }}
      >
        click here
      </a>
    </div>
  );
}
