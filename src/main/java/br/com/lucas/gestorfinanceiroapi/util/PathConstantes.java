package br.com.lucas.gestorfinanceiroapi.util;


public interface PathConstantes {
	
    String PIER_USUARIO = "/usuarios";

    String PIER_NOTIFICACAO_EMAIL = "/notificacoes-email";

    String PIER_ORIGENS_COMERCIAIS = "/origens-comerciais";

    String PIER_CONTA = "/contas";

    String PIER_CLIENTES_PESSOAS_FISICAS = "/clientes-pessoas-fisicas";

    String PIER_PESSOA_FISICAS = "/pessoas";

    String PIER_PRODUTOS = "/produtos";
    
    String PIER_NOTIFICACAO_SMS = "/notificacoes/sms";
    
    String PATH_TEMPLATES_NOTIFICACOES = "/templates-notificacoes";

    String PATH_PUSH_FCM = "/notificacoes/push/fcm";
    
    String PATH_ESTABELECIMENTO_ADQUIRENTE = "/estabelecimentos/{id}/adquirentes";

    String PIER_ENDERECOS = "/enderecos";

    String PIER_TELEFONES = "/telefones";

}
