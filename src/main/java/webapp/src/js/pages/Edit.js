import React from "react";
import Link from "react-router";
import Row from "../components/Row";

export default class List extends React.Component {
  constructor(props){
    super(props);

    //consultamos con la base de datos y tenemos
    this.state = {
      id:1,name:"bancolombia",
      nit:"123"
    };
  }

  changeId(e){
    this.setState({id:e.target.value})
  }
  changeName(e){
    this.setState({name:e.target.value})
  }
  changeNit(e){
    this.setState({nit:e.target.value})
  }
  return(){
    this.props.history.pushState(null,'/' );
  }
  save(){
    //llamar servicio con el valor en el estado para almacenar en bd

    //luego volvemos al listado.
    this.props.history.pushState(null,'/' );
  }


  render() {
    const { query } = this.props.location;
    console.log(query);
    return (
      <div>
        <table>
          <tr>
            <td><label for="id">Id: </label></td>
            <td><input type="text" name="id" id="id" defaultValue={this.state.id} onChange ={this.changeId.bind(this)} /></td>
          </tr>
          <tr>
            <td><label for="nombre">Nombre: </label></td>
            <td><input type="text" name="nombre" id="nombre" defaultValue={this.state.name} onChange ={this.changeName.bind(this)}/></td>
          </tr>
          <tr>
            <td><label for="nit">Nit: </label></td>
            <td><input type="text" name="nit" id="nit" defaultValue={this.state.nit} onChange ={this.changeNit.bind(this)}/></td>
          </tr>
          <tr>
            <td><button onClick={() => { this.save()}} >Guardar</button></td>
            <td><button class="btn-link"  onClick={() => { this.return()}} >Volver</button></td>
          </tr>
        </table>
      </div>
    );
  }
}
