package br.com.lucas.gestorfinanceiroapi.constantes;

public class Constantes {

     public static final String CHARSET = "charset";

     public static final String ACCESS_TOKEN = "access_token";

     public static final int TAMANHO_CAMPO_CPF = 11;

     public static final String CLIENT_ID = "client_id";

     public static final String OAUTH_CODE = "code";

     public static final String OAUTH_GRANT_TYPE = "grant_type";

     public static final String OAUTH_PASSWORD_TYPE = "password";

     public static final String SOURCE_MIDDLEWARE = "MIDDLEWARE";

     public static final String SOURCE_BLUE = "BLUE API";

     public static final String SOURCE_PIER = "PIER API";

     public static final String CONTENT_TYPE = "Content-Type";

     public static final String ACCEPT = "Accept";

     public static final String CONTENT_TYPE_APPLICATTION_JSON = "application/json";

     public static final String CONTENT_TYPE_APPLICATTION_JSON_UTF8 = "application/json;charset=UTF-8";

     public static final String VAR_PIER_URL = "pier_url";

     public static final String VAR_NEUROTECH_POLITICAS_URL = "neurotech_politicas_url";

     public static final String VAR_NEUROTECH_CLIENT_ID = "neurotech_client_id";

     public static final String VAR_NEUROTECH_ACCESS_TOKEN = "neurotech_access_token";

     public static final String VAR_PIER_ACCESS_TOKEN = "pier_access_token";

     public static final String VAR_PIER_CLIENT_ID = "pier_client_id";

     public static final String VAR_PIER_ID_TEMPLATE_EMAIL_RECUPERACAO_SENHAS = "identificacao_template_email_rec_senha";

     public static final String VAR_URL_CADASTRO_SENHA = "url_cadastro_senha";

     public static final String VAR_URL_OAUTH_GERAR_CODIGO = "url_oauth_gerar_codigo";

     public static final String VAR_URL_OAUTH_GERAR_TOKEN = "url_oauth_gerar_token";

     public static final String VAR_DATABASE_NAME = "database_name";

     public static final String CNPJ = "cnpj";

     private static final String PATH_PIER_NOTIFICACOES_SMS = "/api/notificacoes-sms";

     public static final String PATH_PIER_CODIGOS_SEGURANCA_ENVIAR = PATH_PIER_NOTIFICACOES_SMS + "/gerar-codigo-seguranca";

     public static final String PATH_PIER_CODIGOS_SEGURANCA_REENVIAR = PATH_PIER_NOTIFICACOES_SMS + "/reenviar-codigo-seguranca";

     public static final String PATH_PIER_CODIGOS_SEGURANCA_VALIDAR = PATH_PIER_NOTIFICACOES_SMS + "/validar-codigo-seguranca";

     public static final String PATH_PIER_CNAE = "/api/cnaes";

     public static final String PATH_PIER_BANCO = "/api/bancos";

     public static final String PATH_PIER_GRUPO_ECONOMICO = "/api/grupos-economicos";

     public static final String PATH_PIER_ESTABELECIMENTO = "/api/estabelecimentos";

     public static final String PATH_PIER_TELEFONE_ESTABELECIMENTO = "/api/telefones-estabelecimentos";

     public static final String PATH_PIER_USUARIO = "/api/usuarios";

     public static final String PATH_PIER_ENVIAR_EMAIL = "/api/notificacoes-email";
     
     public static final String PARAM_PIER_ACCESS_TOKEN = "access_token";

     public static final String PARAM_PIER_CLIENT_ID = "client_id";

     public static final String PARAM_PIER_CPF = "cpf";

     public static final String PARAM_PIER_CNPJ = "cnpj";

     public static final String PARAM_PIER_ID_PLATAFORMA = "idPlataforma";

     public static final String NEUROTECH_POLITICA = "SANTANDER_P1";

     public static final String FIELD_SERIAL_VERSION_UID = "serialVersionUID";

     public static final String PLATAFORMA_DESCRICAO_CACHE = "PLATAFORMA_DESCRICAO_CACHE";

     public static final String PLATAFORMAS_TOKEN_CACHE = "PLATAFORMAS_TOKEN_CACHE";

     public static final String PATH_CIPHER_DECRYPT = "/decrypt";

     public static final String PATH_CIPHER_GERAR_PIN = "/gerarpin";

     public static final String USUARIO_RESPONSAVEL = "PIER";

     public static final Integer CARTOES = 23;
     
     public static final String PATH_BLUE_SOCIOS = "/socios";
     
     public static final String PATH_BLUE_ESTABELECIMENTOS = "/estabelecimentos";
     
     public static final String PATH_INSCRICOES = "/inscricoes";
     
     public static final String TIPO_ESTABELECIMENTO_RESTAURANTE = "Restaurante";
     

}
