import React from "react";
import ReactDOM from "react-dom";
import { Router, Route, IndexRoute, browserHistory  } from "react-router";

import Edit from "./pages/Edit";
import List from "./pages/List";
import Layout from "./pages/Layout";


const app = document.getElementById('app');
/*
<Router history={hashHistory}>
  <Route path="/" component={Layout}>
    <IndexRoute component={List}></IndexRoute>
    <Route path="edit(/:id)" name="editar" component={Edit}></Route>
  </Route>
</Router>


<List rows = {rows} />
*/
const  rows  = [{id:1,name:"bancolombia",nit:"123"},{id:2,name:"banco bogota",nit:"124"}];


ReactDOM.render(
  <Router history={browserHistory}>
    <Route name="principal" path="/" component={Layout}>
      <IndexRoute component={List}></IndexRoute>
      <Route name="listar" path="/"  component={List}></Route>
      <Route name="editar" path="/edit/:id"  component={Edit}></Route>
    </Route>
  </Router>
,
app);
