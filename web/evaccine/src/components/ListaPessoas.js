import React, { Component } from "react";
import {Table, Tag, Space, Button, message} from 'antd';
import PessoaDataService from "../services/PessoaDataService";
const {Column} = Table

export default class ListaPessoas extends Component{

    constructor (props){
        super(props)
        this.state={
            pessoas:[],
            message: null
        }
    }

    componentDidMount(){
        this.refreshPessoas();
    }

    refreshPessoas(){
        PessoaDataService.retriveAllPessoas()
            .then(
                response => {
                    console.log(response);
                    this.setState({pessoas:response.data})
                }
            )
    }

    successUpdate= (record)=>{
        if(record.isVacinada){
            record.isVacinada=false;
        }
        else{
            record.isVacinada=true;
        }
        PessoaDataService.updatePessoa(record, record.codigo);
        message.success('Atualização realizada com sucesso.')
    }

    render(){
        return (
            <div className="container">
                <h2><br/>Pessoas Cadastradas<br/></h2>
                
                <div className="container">
                    <Table dataSource={this.state.pessoas}>
                        <Column title="Nome" dataIndex="nome" key="nome"/>
                        <Column title="CPF" dataIndex="cpf" key="cpf"/>
                        <Column title="Telefone" dataIndex="telefone" key="telefone"/>
                        <Column title="Email" dataIndex="email" key="email"/>
                        <Column title="Recebeu a vacina?" dataIndex="isVacinada" key="isVacinada"
                                render = {(text, record) => (<p>{String(record.isVacinada)}</p>)}/>
                        <Column title="Atualizar" key="atualizar"
                                render = {(text, record) => (<Button onClick={()=> this.successUpdate(record)} type="primary">Alterar status</Button>)}/>

                    </Table>
                </div>
            </div>
        )
    }
}