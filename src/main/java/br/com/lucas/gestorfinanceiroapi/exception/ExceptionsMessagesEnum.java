package br.com.lucas.gestorfinanceiroapi.exception;



import static java.util.Arrays.asList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.PRECONDITION_FAILED;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public enum ExceptionsMessagesEnum {

    GLOBAL_BAD_REQUEST(BAD_REQUEST, "Falha na requisição" , BadRequestCustom.class),
    GLOBAL_ERRO_SERVIDOR(INTERNAL_SERVER_ERROR, "Erro interno de servidor", ExceptionCustom.class),
    GLOBAL_RECURSO_NAO_ENCONTRADO(NOT_FOUND, "Recurso não encontrado", NotFoundCustom.class),
    ENDERECO_RASTREO_NAO_ENCONTRADO(INTERNAL_SERVER_ERROR, "Endereço rastreo não encotrado", ExceptionCustom.class),
    ESTABELECIMENTO_NAO_ENCONTRADO(NOT_FOUND, "Estabelecimento não encontrado", NotFoundCustom.class),
    EMPRESA_JA_CADASTRADA(BAD_REQUEST, "Empresa já cadastrada", BadRequestCustom.class),
    PESSOA_CPF_INVALIDO(BAD_REQUEST, "Pessoa cpf invalido", BadRequestCustom.class),
    PESSOA_CNPJ_INVALIDO(BAD_REQUEST, "Pessoa cnpj invalido", BadRequestCustom.class),
    SOCIO_JA_CADASTRADO(CONFLICT, "Socio ja existe", ConflictedCustom.class),
    SOCIO_NAO_ENCONTRADO(NOT_FOUND, "Socio nao encontrado", ConflictedCustom.class),
    SOCIO_NEUROTECH(UNPROCESSABLE_ENTITY, "Estabelecimento socio neurotech", UnprocessableEntityCustom.class),
    CARTAO_SENHA_INVALIDA(BAD_REQUEST, "Cartão senha inválido", BadRequestCustom.class),
    CARTAO_REGISTRO_NAO_ENCONTRADO(NOT_FOUND, "Cartão registro não encontrado", NotFoundCustom.class),
    CARTAO_INVALIDO(BAD_REQUEST, "Cartão inválido", BadRequestCustom.class),
    CARTAO_NAO_CONTEM_DADOS_CRIPTOGRAFIA(BAD_REQUEST, "Cartão não contém dados criptografia", BadRequestCustom.class),
    CARTAO_SENHA_NULA(BAD_REQUEST, "Cartão senha nula", BadRequestCustom.class),
    CARTAO_VALIDACAO_MAL_SUCEDIDA(BAD_REQUEST, "Cartão validação mal sucedida", BadRequestCustom.class),
    GLOBAL_ERRO_VALIDACAO_CIPHER(BAD_REQUEST, "Global erro validação cipher", BadRequestCustom.class),
    GLOBAL_ERRO_CONEXAO_CIPHER(INTERNAL_SERVER_ERROR, "Global erro conexão cipher", ExceptionCustom.class),
    GLOBAL_ERRO_GENERIGO_CIPHER(BAD_REQUEST, "Global erro generigo cipher", BadRequestCustom.class),
    CARTAO_STATUS_NAO_INFORMADO_OU_INVALIDO(BAD_REQUEST, "Cartão status não informado ou inválido", BadRequestCustom.class),
    CARTAO_STATUS_JA_INFORMADO(BAD_REQUEST, "Cartão status já informado", BadRequestCustom.class),
    CARTAO_STATUS_INFORMADO_INVALIDO(BAD_REQUEST, "cartao status informado inválido", BadRequestCustom.class),
    CONTA_NAO_ENCONTRADO(NOT_FOUND, "Conta não encontrado", NotFoundCustom.class),
    PRODUTO_NAO_ENCONTRADO(NOT_FOUND, "Produto não encontrado", NotFoundCustom.class),
    SOCIO_PRINCIPAL_EMAIL_NAO_INFORMADO(BAD_REQUEST, "E-mail não informado para o contato principal", NotFoundCustom.class),
    ID_GRUPO_EMPRESA_NULL(BAD_REQUEST, "IdGrupoEmpresa nulo", BadRequestCustom.class),
    PARAMETROS_GRUPO_EMPRESA_NAO_CADASTRADO(BAD_REQUEST, "Parametros grupo empresa não cadastrado", BadRequestCustom.class),
    SUBGRUPO_EMPRESA_NAO_CADASTRADO(BAD_REQUEST, "SubGrupo não cadastrado", BadRequestCustom.class),
    SUBGRUPOS_NAO_LOCALIZADOS(NO_CONTENT, "Grupo-empresa não possui subgrupos", NoContentCustom.class),
    USUARIO_JA_CADASTRADO(BAD_REQUEST, "Usuário já cadastrado com este CPF", BadRequestCustom.class),
    EMAIL_JA_CADASTRADO(BAD_REQUEST, "E-mail já cadastrado", BadRequestCustom.class),
    TIPO_PRODUTO_VR_NAO_CADASTRADO(BAD_REQUEST, "Tipo produto VR não cadastrado", BadRequestCustom.class),
    PRAZO_INVALIDO(BAD_REQUEST, "Prazo pagamento invalido", BadRequestCustom.class),
    EMPRESA_NAO_ENCONTRADA(NOT_FOUND, "Empresa não encontrada", NotFoundCustom.class),
    PARAMETRO_GRUPO_NAO_ENCONTRADO(BAD_REQUEST, "Paramentro empresa não localizado", BadRequestCustom.class),
    PESSOA_NAO_ENCONTRADA(NOT_FOUND, "Pessoa não encontrada", NotFoundCustom.class),
    USUARIO_NAO_ENCONTRADO(NOT_FOUND, "Usuário não existe", NotFoundCustom.class),
    USUARIO_REGISTRO_NAO_ENCOTRADO(NOT_FOUND, "Usuário registro não encontrado", NotFoundCustom.class),
    USUARIO_OBRIGATORIO(BAD_REQUEST, "Usuário é obrigatório", BadRequestCustom.class),
    BANCO_NAO_EXISTE(BAD_REQUEST, "O código do banco informado não existe.", BadRequestCustom.class),
    CNAE_NAO_EXISTE(NOT_FOUND, "CNAE inválido.", NotFoundCustom.class),
    PERIODO_INCORRETO(BAD_REQUEST, "Período selecionado está incorreto", BadRequestCustom.class),
    PERIODO_SUPERIOR(BAD_REQUEST, "Período selecionado está superior a 6 meses", BadRequestCustom.class),
    PARAMETRO_NAO_ENCONTRADO(NOT_FOUND, "Parametro não encontrado", NotFoundCustom.class),
    GRUPO_EMPRESA_NAO_ENCONTRADO(NOT_FOUND, "Grupo empresa não encontrado", NotFoundCustom.class),
    CONTA_NAO_ENCONTRADA(NOT_FOUND, "Conta não encontrada", NotFoundCustom.class),
    TIPO_PRODUTO_NAO_CADASTRADO(BAD_REQUEST, "tipo produto não cadastrado", BadRequestCustom.class),
    RECURSO_NAO_ENCONTRADO(NO_CONTENT, "Recurso não encotrado", NoContentCustom.class),
    CAMPOS_OBRIGATORIO(BAD_REQUEST, "Campos obrigatórios não foram preenchidos.", BadRequestCustom.class),
    PRECONDICOES_NAO_ATENDIDAS(UNPROCESSABLE_ENTITY, "Não é possivel inserir mais de uma taxa ativa para o mesmo Estabelecimento/Produto/Adquirente.", UnprocessableEntityCustom.class),
    TIPO_PRODUTO_NAO_LOCALIZADO(NOT_FOUND, "Recurso não encotrado", NotFoundCustom.class),
    NIVEL_PERFIL_USUARIO_NAO_ENCOTRADO(NOT_FOUND, "Nível perfil de usuário não encontrado", NotFoundCustom.class),
    SUBTIPO_ESTABELECIMENTO_OBRIGATORIO(BAD_REQUEST, "O Subtipo é obrigatório caso o Tipo seja Restaurante", BadRequestCustom.class),
    PESQUISA_NAO_ENCONTRADA(NO_CONTENT, "Registros não encontrados", NoContentCustom.class),
    MOEDA_NAO_ENCONTRADA(NOT_FOUND, "Moeda não encontrada", NotFoundCustom.class),
    TIPO_ESTABELECIMENTO_INVALIDO(NOT_FOUND, "Tipo estabelecimento não encontrado", NotFoundCustom.class),
    ID_PAIS_INVALIDO(NOT_FOUND, "Identificador do país inválido", NotFoundCustom.class),
    CODIGO_MCC_INVALIDO(NOT_FOUND, "MCC inválido", NotFoundCustom.class),
    USUARIO_JA_VINCULADO(CONFLICT, "Usuário já vinculado", ConflictedCustom.class),
    ESTABELECIMENTO_PAI_NAO_ENCONTRADO(NOT_FOUND, "Estabelecimento Pai não encontrado", NotFoundCustom.class),
    ESTABELECIMENTO_REPETIDO(BAD_REQUEST, "Estabelecimento já cadastrado para o CNPJ", BadRequestCustom.class),
    TOTAL_TERMINAIS_ESTABELECIMENTOS_EXCEDIDO(BAD_REQUEST, "Total de Terminais excedido por estabelecimento", BadRequestCustom.class),
    CREDOR_NAO_ENCONTRADO(NOT_FOUND, "Credor não encontrado", NotFoundCustom.class),
    GRUPO_ESTABELECIMENTO_NAO_ENCONTRADO(NOT_FOUND, "Grupo Estabelecimento não encontrado", NotFoundCustom.class),
    REQUISICAO_MAL_FORMATADO(BAD_REQUEST, "Json mal formatado ou atributos invalidos para operacao", BadRequestCustom.class),
    INVALID_TELEFONE(BAD_REQUEST, "Telefone invalido.", BadRequestCustom.class),
    PROBLEMA_SOCIO_NAO_PRESENTE_CADEIA(UNPROCESSABLE_ENTITY, "O CPF informado não consta na cadeia societária.", UnprocessableEntityCustom.class),
    PROBLEMA_SOCIO_NAO_PRESENTE_NEUROTECH(UNPROCESSABLE_ENTITY, "Socios nao presente no retorno neurotech.", UnprocessableEntityCustom.class),
    CNAE_NAO_VINCULADO(UNPROCESSABLE_ENTITY, "CNAE nao vinculado.", UnprocessableEntityCustom.class),
    PROBLEMA_COMUNICACAO_NEUROTECH(UNPROCESSABLE_ENTITY, "Problema na validacao dos dados.", UnprocessableEntityCustom.class),
    CNPJ_NAO_LIBERADO(UNPROCESSABLE_ENTITY, "CNPJ invalido para operacao.", UnprocessableEntityCustom.class),
    CPF_NOT_NULL(BAD_REQUEST, "CPF nao pode ser nulo.", BadRequestCustom.class),
    INVALID_CPF(BAD_REQUEST, "CPF invalido", BadRequestCustom.class),
    PLATAFORMA_INVALIDA(BAD_REQUEST, "Plataforma invalida", BadRequestCustom.class),
    CANAL_INVALIDO(BAD_REQUEST, "O canal informado é inválido", BadRequestCustom.class),
    MODELO_CENTRALIZADO_NAO_PERMITE_NOVOS_SUBGRUPOS(BAD_REQUEST, "Modelo centralizado não permite inclusão de novos subgrupos", BadRequestCustom.class),
    ERRO_AO_CADASTRAR_EMPRESA(BAD_REQUEST, "Erro ao cadastrar empresa", BadRequestCustom.class),
    TOKEN_NOT_NULL(BAD_REQUEST, "Token nao pode ser nulo.", BadRequestCustom.class),
    TELEFONE_DDD_TAMANHO_INVALIDO(BAD_REQUEST, "DDD do telefone deve conter 2 dígitos.", BadRequestCustom.class),
    TELEFONE_TAMANHO_INVALIDO(BAD_REQUEST, "Telefone deve conter 9 digitos.", BadRequestCustom.class),
    TELEFONE_NOT_NULL(BAD_REQUEST, "Telefone nao pode ser nulo.", BadRequestCustom.class),
    TELEFONE_DDD_NOT_NULL(BAD_REQUEST, "DDD do telefone nao pode ser nulo.", BadRequestCustom.class),
    TIPO_INSCRICAO_INVALIDO(BAD_REQUEST, "Tipo de inscrição não encontrado", BadRequestCustom.class),
    INFORMACOES_NAO_ENCONTRADAS(NO_CONTENT, "Informações não encontradas", NoContentCustom.class),
    ERRO_CADASTRAR_USUARIO_SOCIO(INTERNAL_SERVER_ERROR, "Erro ao cadastrar usuário para o sócio", ExceptionCustom.class),
    SOCIO_PRINCIPAL_EMAIL_E_TELEFONE_NAO_INFORMADO(BAD_REQUEST, "E-mail e telefone não informado para o sócio principal", BadRequestCustom.class),
    TEMPLATE_NAO_ENCONTRADO(INTERNAL_SERVER_ERROR, "Template não encontrado.", ExceptionCustom.class),
    ERRO_AO_SALVAR_NSU(BAD_REQUEST, "Erro ao salvar Nsu", BadRequestCustom.class),
    FUNCIONARIO_NAO_ENCONTRADO(NOT_FOUND, "O código do funcionário não existe.", NotFoundCustom.class),
    ERRO_AO_DELETAR_SOCIOS(BAD_REQUEST, "Erro ao deletar o sócio", BadRequestCustom.class),
    VINCULO_USUARIO_ESTABELECIMENTO_INEXISTENTE(NOT_FOUND, "Usuário não possui vínculo com o estabelecimento", NotFoundCustom.class),
    VINCULO_USUARIO_ESTABELECIMENTO_NIVEL_EXISTENTE(BAD_REQUEST,"Usuário já possui esse nível de permissão de acesso", BadRequestCustom.class),
    REENVIO_OBRIGATORIO(BAD_REQUEST,"Reenvio é obrigatório",BadRequestCustom.class),
    GRUPO_EMPRESA_OBRIGATORIO(BAD_REQUEST,"Grupo Empresa é obrigatório",BadRequestCustom.class),
    PERMISSAO_USUARIO_GRUPO_EMPRESA_EXISTENTE(CONFLICT,"Permissão já cadastrado para esse usuário com o grupo empresa",ConflictedCustom.class),
    USUARIO_REGISTRO_NAO_ENCONTRADO(NOT_FOUND, "Usuário Registro não existe", NotFoundCustom.class),
    USUARIO_REGISTRO_OBRIGATORIO(BAD_REQUEST, "Usuário Registro é obrigatório", BadRequestCustom.class),
    USUARIO_REGISTRO_SEM_PERMISSAO(BAD_REQUEST, "Usuário Registro não possui vínculo para realizar essa operação", BadRequestCustom.class),
    USUARIO_REGISTRO_SEM_PERMISSAO_PARA_ACAO(FORBIDDEN, "Usuário Registro não possui vínculo para realizar essa operação", ForbiddenCustom.class),
    PERMISSAO_NAO_ENCONTRADA(NOT_FOUND, "Permissão não encontrada", NotFoundCustom.class),
    SUBGRUPO_NAO_LOCALIZADO(BAD_REQUEST, "Subgrupo não localizado.", BadRequestCustom.class),
    SUBRGRUPO_NAO_EXISTE(NOT_FOUND, "Registros não encontrados", NotFoundCustom.class),
    ID_INFORMADO_NAO_E_DE_SUBGRUPO(BAD_REQUEST, "Id informado não é Subgrupo.", BadRequestCustom.class),
    NENHUMA_EMPRESA_LISTADA(NOT_FOUND, "Id informado não é Subgrupo.", NotFoundCustom.class),
    PERMISSAO_NAO_LOCALIZADA(BAD_REQUEST,"Reenvio é obrigatório",BadRequestCustom.class),
    OPERACAO_NAO_LOCALIZADA(BAD_REQUEST,"Reenvio é obrigatório",BadRequestCustom.class),
    CPF_NAO_PODE_SER_ALTERADO(BAD_REQUEST,"O CPF não deve ser alterado" ,BadRequestCustom.class),
    ERRO_CADASTRAR_PUSH_NOTIFICATIONS(INTERNAL_SERVER_ERROR, "Erro ao cadastrar push notifications", ExceptionCustom.class),
    STATUS_INVALIDO(BAD_REQUEST, "Status inválido", BadRequestCustom.class),
    CHAVE_CRIPTOGRAFIA_NAO_ENCONTRADA(NOT_FOUND, "Chave de criptografia não encontrada.", NotFoundCustom.class),
    OPERACAO_INVALIDA(NOT_FOUND,"Operação invalida" ,NotFoundCustom.class),
    PERMISSAO_OPERACAO_NAO_ENCONTRADA(NOT_FOUND, "Vinculo de permissão operação não encontrada", NotFoundCustom.class),
    CONFLITO_DE_PERMISSAO(CONFLICT,"Permissão e operação já vinculada para este usuário" ,ConflictedCustom.class),
    FORMA_DE_FATURAMENTO_INVALIDA( BAD_REQUEST ,"Forma de furamento e pedido inválida" , BadRequestCustom.class),
    VINCULO_ACESSO_USUARIO_EC_NAO_ENCONTRADO(HttpStatus.NO_CONTENT, "Vinculo acesso usuário não encontrado.", NotFoundCustom.class),
    DATA_ATIVA_OBRIGATORIO(BAD_REQUEST, "Data ativação é obrigatória.", BadRequestCustom.class),
    ID_PRODUTO_OBRIGATORIO(BAD_REQUEST, "Id do Produto é obrigatório.", BadRequestCustom.class),
    DEVE_SER_INFORMADA_UM_ADQUIRENTE(BAD_REQUEST, "Deve ser informado ao menos um id de adquirente.", BadRequestCustom.class),
    TAXA_COMPATIVEL_ADQUIRENTE(BAD_REQUEST, "A taxa deve ser compatível com o adquirente informado e não pode ser vazia.", BadRequestCustom.class),
    PERFIL_OBRIGATORIO(BAD_REQUEST,"Perfil é obrigatório.", BadRequestCustom.class),
    PERFIL_INVALIDO(BAD_REQUEST,"Perfil inválido.", BadRequestCustom.class),
    ERRO_NA_CRIACAO_DO_USUARIO(BAD_REQUEST, "Erro na criação do usuário.", BadRequestCustom.class),
    USUARIO_ATIVO(BAD_REQUEST,"Usuário ativo.", BadRequestCustom.class),
    NIVEIS_ACESSO_USUARIO_NAO_ENCONTRADO(NOT_FOUND, "Níveis de acesso não encontrados.", NotFoundCustom.class),
    ERRO_NA_CRIACAO_DO_VINCULO_ACESSO(BAD_REQUEST, "Erro na criação do vinculo de acesso do usuário.", BadRequestCustom.class),
    TAXA_ADQUIRENTE_NAO_ENCONTRADO(BAD_REQUEST, "Adquirente informado não encontrado.", BadRequestCustom.class),
    CNAE_SECUNDARIO_NAO_VINCULADO(UNPROCESSABLE_ENTITY, "CNAE Secundário não vinculado.", UnprocessableEntityCustom.class),
    ID_GRUPO_OBRIGATORIO(BAD_REQUEST, "Id do Grupo empresa é obrigatório", BadRequestCustom.class),
    SUBGRUPO_NAO_PODE_SER_ATUALIZADO(BAD_REQUEST, "Subgrupo não é um grupo para ser atualizado", BadRequestCustom.class),
    EMPRESA_NAO_FAZ_PARTE_GRUPO(BAD_REQUEST, "Empresa não faz parte do grupo", BadRequestCustom.class),
    NIVEL_ACESSO_NAO_EXISTE(NOT_FOUND, "Indentificador de nível acesso informado não existe", NotFoundCustom.class),
    NIVEL_DE_ACESSO_JA_EXISTE(CONFLICT, "Nível de perfil já existe", ConflictedCustom.class),
    NIVEL_PERMISSAO_ACESSO_NAO_ENCONTRADA(NOT_FOUND,"Nível permissão acesso não encontrada" ,NotFoundCustom.class),
    NIVEL_PERMISSAO_ACESSO_NAO_AUTORIZADO(FORBIDDEN,"Nível permissão acesso não autorizado" ,ForbiddenCustom.class),
    LISTA_DE_NIVEL_POR_GRUPO_ACEITA_APENAS_UM_PARAMETRO(BAD_REQUEST,"Lista de nível acesso grupo aceita apenas um parametro" ,BadRequestCustom.class),
    ADQUIRENTE_NAO_ENCONTRADO(BAD_REQUEST, "Adquirente informado não encontrado.", BadRequestCustom.class),
    ERRO_INFORMAR_TODAS_TAXAS_ATIVA(UNPROCESSABLE_ENTITY, "Não é possível salvar todos os tipos de taxas ativas.", UnprocessableEntityCustom.class),
    ERRO_TAXA_MESMO_ADQUIRENTE(UNPROCESSABLE_ENTITY, "Não é possível salvar mais de uma taxa para o mesmo adquirente.", UnprocessableEntityCustom.class),
    ERRO_LISTA_TAXAS_VAZIA(BAD_REQUEST, "A lista de taxas não pode ser vazia.", BadRequestCustom.class),
    ERRO_PRE_CONDICOES_TAXAS(UNPROCESSABLE_ENTITY, "As pré-condições de cadastro do(s) tipo(s) de taxa(s) não foram atendidas.", UnprocessableEntityCustom.class),
    ERRO_TAXAS_POR_PRODUTO(UNPROCESSABLE_ENTITY, "Não é possível inserir mais de uma taxa por Produto.", UnprocessableEntityCustom.class),
    DADOS_ATUALIZACAO_NAO_INFORMADOS(PRECONDITION_FAILED, "Dados para a atualização do registros não informados.", PreconditionCustom.class),
    ERRO_SUBGRUPO_NAO_E_GRUPO(PRECONDITION_FAILED, "Subgrupo não é do grupo de empresas informado.", PreconditionCustom.class),
    ERRO_EMPRESA_NAO_E_DE_SUBGRUPO(PRECONDITION_FAILED, "Empresa não é do subgrupo de empresas informado.", PreconditionCustom.class),
    VINCULO_JA_EXISTE(BAD_REQUEST, "Vínculo requisitado já existe.", BadRequestCustom.class),
    SENHA_NAO_ATENDE_AO_PADRAO(BAD_REQUEST, "Senha não atende ao padrão.", BadRequestCustom.class),
    TOKEN_INFORMADO_NAO_LOCALIZADO(BAD_REQUEST, "Token informado não localizado.", BadRequestCustom.class),
    ERRO_AO_SALVAR_O_ESTABELECIMENTO(BAD_REQUEST, "Ocorreu um erro ao salvar o Estabelecimento.", BadRequestCustom.class),
    TOKEN_EXPIRADO(BAD_REQUEST, "Token expirado.", BadRequestCustom.class), 
    VINCULO_ESTABELECIMENTO_PRODUTO_JA_EXISTE(BAD_REQUEST, "Vínculo requisitado já existe.", BadRequestCustom.class),
    PALAVRAS_CONTIDAS_BLACKLIST(PRECONDITION_FAILED, "Palavras não permitidas.", PreconditionCustom.class),
    ID_ESTABELECIMENTO_OBRIGATORIO(BAD_REQUEST, "Identificador Estabelecimento é obrigatório.", BadRequestCustom.class),
    ESTABELECIMENTO_NAO_ENCONTRADO_400(BAD_REQUEST, "Estabelecimento não encontrado.", BadRequestCustom.class),
    SENHA_OBRIGATORIO_400(BAD_REQUEST, "Senha é obrigatório.", BadRequestCustom.class),
    ;

    private HttpStatus code;

    @Setter
    private String message;

    private Class<? extends ExceptionCustom> klass;

    ExceptionsMessagesEnum(HttpStatus code, String message, Class<? extends ExceptionCustom> klass) {

        this.message = message;
        this.klass = klass;
        this.code = code;
    }

    public static ExceptionsMessagesEnum getEnum(final String key) {

        return asList(ExceptionsMessagesEnum.values()).stream().filter(e -> StringUtils.equals(e.getMessage(), key)).findAny().orElse(null);
    }

    public void raise() throws ExceptionCustom {

        log.debug("Raising error: {}", this);
        switch (this.code) {
            case BAD_REQUEST:
                throw new BadRequestCustom(this.message);
            case NOT_FOUND:
                throw new NotFoundCustom(this.message);
            case CONFLICT:
                throw new ConflictedCustom(this.message);
            case UNPROCESSABLE_ENTITY:
                throw new UnprocessableEntityCustom(this.message);
            case NO_CONTENT:
                throw new NoContentCustom(this.message);
            case PRECONDITION_FAILED:
            	throw new PreconditionCustom(this.message);
            case FORBIDDEN:
              throw new ForbiddenCustom(this.message);
            default:
                throw new ExceptionCustom(INTERNAL_SERVER_ERROR, this.message);
        }
    }

    public void raise(String errorMessage) {

        this.setMessage(errorMessage);
        this.raise();
    }

    public void raiseLogError(String... textoErro) {

        asList(textoErro).stream().forEach(erro -> log.error(erro));
        raise();
    }

}
