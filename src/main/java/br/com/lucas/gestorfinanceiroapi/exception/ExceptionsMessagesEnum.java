package br.com.lucas.gestorfinanceiroapi.exception;



import static java.util.Arrays.asList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public enum ExceptionsMessagesEnum {
	
	CATEGORIA_NAO_ENCONTRADA(NOT_FOUND, "Categoria não encontrada", NotFoundCustom.class),
	CARTAO_NAO_ENCONTRADO(NOT_FOUND, "Cartão não encontrado", NotFoundCustom.class),
	CONTA_NAO_ENCONTRADA(NOT_FOUND, "Conta não encontrada", NotFoundCustom.class),
	DESPESA_NAO_ENCONTRADA(NOT_FOUND, "Despesa não encontrada", NotFoundCustom.class),
	RECEITA_NAO_ENCONTRADA(NOT_FOUND, "Receita não encontrada", NotFoundCustom.class),
	REQUIRED_ID(BAD_REQUEST, "Id requerido" , BadRequestCustom.class),

    GLOBAL_BAD_REQUEST(BAD_REQUEST, "Falha na requisição" , BadRequestCustom.class),
    GLOBAL_ERRO_SERVIDOR(INTERNAL_SERVER_ERROR, "Erro interno de servidor", ExceptionCustom.class),
    GLOBAL_RECURSO_NAO_ENCONTRADO(NOT_FOUND, "Recurso não encontrado", NotFoundCustom.class),
    GLOBAL_ERRO_VALIDACAO_CIPHER(BAD_REQUEST, "Global erro validação cipher", BadRequestCustom.class),
    
    
    EMPRESA_JA_CADASTRADA(BAD_REQUEST, "Empresa já cadastrada", BadRequestCustom.class),
    PESSOA_CPF_INVALIDO(BAD_REQUEST, "Pessoa cpf invalido", BadRequestCustom.class),
    PESSOA_CNPJ_INVALIDO(BAD_REQUEST, "Pessoa cnpj invalido", BadRequestCustom.class),
    CONTA_NAO_ENCONTRADO(NOT_FOUND, "Conta não encontrado", NotFoundCustom.class),
    EMAIL_JA_CADASTRADO(BAD_REQUEST, "E-mail já cadastrado", BadRequestCustom.class),
    PRAZO_INVALIDO(BAD_REQUEST, "Prazo pagamento invalido", BadRequestCustom.class),
    PESSOA_NAO_ENCONTRADA(NOT_FOUND, "Pessoa não encontrada", NotFoundCustom.class),
    USUARIO_NAO_ENCONTRADO(NOT_FOUND, "Usuário não existe", NotFoundCustom.class),
    USUARIO_REGISTRO_NAO_ENCOTRADO(NOT_FOUND, "Usuário registro não encontrado", NotFoundCustom.class),
    USUARIO_OBRIGATORIO(BAD_REQUEST, "Usuário é obrigatório", BadRequestCustom.class),
    BANCO_NAO_EXISTE(BAD_REQUEST, "O código do banco informado não existe.", BadRequestCustom.class),
    PARAMETRO_NAO_ENCONTRADO(NOT_FOUND, "Parametro não encontrado", NotFoundCustom.class),
    RECURSO_NAO_ENCONTRADO(NO_CONTENT, "Recurso não encotrado", NoContentCustom.class),
    CAMPOS_OBRIGATORIO(BAD_REQUEST, "Campos obrigatórios não foram preenchidos.", BadRequestCustom.class),
    PESQUISA_NAO_ENCONTRADA(NO_CONTENT, "Registros não encontrados", NoContentCustom.class),
    REQUISICAO_MAL_FORMATADO(BAD_REQUEST, "Json mal formatado ou atributos invalidos para operacao", BadRequestCustom.class),
    INVALID_TELEFONE(BAD_REQUEST, "Telefone invalido.", BadRequestCustom.class),
    CPF_NOT_NULL(BAD_REQUEST, "CPF nao pode ser nulo.", BadRequestCustom.class),
    INVALID_CPF(BAD_REQUEST, "CPF invalido", BadRequestCustom.class),
    TOKEN_NOT_NULL(BAD_REQUEST, "Token nao pode ser nulo.", BadRequestCustom.class),
    TELEFONE_DDD_TAMANHO_INVALIDO(BAD_REQUEST, "DDD do telefone deve conter 2 dígitos.", BadRequestCustom.class),
    TELEFONE_TAMANHO_INVALIDO(BAD_REQUEST, "Telefone deve conter 9 digitos.", BadRequestCustom.class),
    TELEFONE_NOT_NULL(BAD_REQUEST, "Telefone nao pode ser nulo.", BadRequestCustom.class),
    TELEFONE_DDD_NOT_NULL(BAD_REQUEST, "DDD do telefone nao pode ser nulo.", BadRequestCustom.class),
    INFORMACOES_NAO_ENCONTRADAS(NO_CONTENT, "Informações não encontradas", NoContentCustom.class),
    ERRO_CADASTRAR_USUARIO_SOCIO(INTERNAL_SERVER_ERROR, "Erro ao cadastrar usuário para o sócio", ExceptionCustom.class),
    NENHUMA_EMPRESA_LISTADA(NOT_FOUND, "Id informado não é Subgrupo.", NotFoundCustom.class),
    CPF_NAO_PODE_SER_ALTERADO(BAD_REQUEST,"O CPF não deve ser alterado" ,BadRequestCustom.class),
    STATUS_INVALIDO(BAD_REQUEST, "Status inválido", BadRequestCustom.class),
    CHAVE_CRIPTOGRAFIA_NAO_ENCONTRADA(NOT_FOUND, "Chave de criptografia não encontrada.", NotFoundCustom.class),
    OPERACAO_INVALIDA(NOT_FOUND,"Operação invalida" ,NotFoundCustom.class),
    ERRO_NA_CRIACAO_DO_USUARIO(BAD_REQUEST, "Erro na criação do usuário.", BadRequestCustom.class),
    USUARIO_ATIVO(BAD_REQUEST,"Usuário ativo.", BadRequestCustom.class),
    SENHA_NAO_ATENDE_AO_PADRAO(BAD_REQUEST, "Senha não atende ao padrão.", BadRequestCustom.class),
    TOKEN_INFORMADO_NAO_LOCALIZADO(BAD_REQUEST, "Token informado não localizado.", BadRequestCustom.class),
    TOKEN_EXPIRADO(BAD_REQUEST, "Token expirado.", BadRequestCustom.class), 
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
