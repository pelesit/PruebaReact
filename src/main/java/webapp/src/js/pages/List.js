import React from "react";
import Link  from "react-router";
import {browserHistory} from 'react-router';
import Row from "../components/Row";

export default class List extends React.Component {

  constructor(props) {
    super(props)
    this.state = { bancos: [] }
  }

  componentWillMount() {
      fetch('http://pruebareact.com:2222/home/listBancos')
        .then((response) => {
          return response.json()
        })
        .then((bancos) => {
          this.setState({ bancos: bancos })
        })
    }



  render() {
    const { query } = this.props.location;


//      const  rows  = [{id:1,name:"bancolombia",nit:"123"}]
      const  rows  = this.state.bancos
                        .map((item,index) => <Row id={item.id} name={item.name} nit={item.nit} history = {this.props.history} /> );

    return (
      <div>
        <Link to="Edit" >Nuevo</Link>
        ----
        <div class="div-table">
          <div class="div-table-row">
            <div  class="div-table-col-name">Id</div>
            <div  class="div-table-col-name">Nombre</div>
            <div  class="div-table-col-name">Nit</div>
            <div  class="div-table-col-name">X</div>
            <div  class="div-table-col-name">=x</div>

          </div>

          <div >{rows}</div>

        </div>
      </div>

    );
  }
}
