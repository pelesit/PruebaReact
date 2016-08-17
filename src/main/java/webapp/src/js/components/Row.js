import React from "react";
import {Link} from 'react-router';

export default class Row extends React.Component {

  editData(id){
    this.props.history.pushState(null,'/Edit/' + id);
  }

  render() {
    const  bank  = this.props;

    return (
      <div class="div-table-row">
        <div  class="div-table-col">{bank.id}</div>
        <div  class="div-table-col">{bank.name}</div>
        <div  class="div-table-col">{bank.nit}</div>
        <div  class="div-table-col">2</div>
        <div  class="div-table-col"><button class="btn-link"  onClick={() => { this.editData(bank.id)}} >Editar</button></div>
      </div>
    );
  }
}
