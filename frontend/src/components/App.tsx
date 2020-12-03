import React from 'react';
import {Switch, Route} from 'react-router-dom';
import {Header} from './common/Header';
import {Footer} from './common/Footer';
import {Authorisation} from './authorisationPage/Authorisation';
import {Redirection} from './authorisationPage/Redirection';
import {Main} from './mainPage/Main';

const SERVER_URL = 'http://localhost:8080';
const REDIRECT_URI = '/oauth2/redirect';
export const OAUTH2_ADDRESS = SERVER_URL + '/oauth2/authorize/google';

export function App() {
  return (
    <div className="App">
      <Header />
      <Switch>
        <Route exact path="/" component={Authorisation} />
        <Route exact path={REDIRECT_URI} component={Redirection} />
        <Route exact path="/main" component={Main} />
      </Switch>
      <Footer />
    </div>
  );
}
