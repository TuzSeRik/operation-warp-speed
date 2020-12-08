import React from 'react';
import {Switch, Route} from 'react-router-dom';
import {Header} from '../commonComponents/Header/Header';
import {Footer} from '../commonComponents/Footer/Footer';
import {Authorisation} from '../authorisationPage/Authorisation/Authorisation';
import {Redirection} from '../authorisationPage/Redirection/Redirection';
import {Main} from '../mainPage/Main/Main';
import {REDIRECT_URI} from '../constants';

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
