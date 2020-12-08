import React from 'react';
import {useDispatch} from 'react-redux';
import {useHistory} from 'react-router-dom';
import {redirection} from './redirectionSlice';

export function Redirection() {
  const dispatch = useDispatch();
  const history = useHistory();

  dispatch(redirection(window.location.search));
  history.push('/main');

  return <div>If you see this message, try to reload page</div>;
}
