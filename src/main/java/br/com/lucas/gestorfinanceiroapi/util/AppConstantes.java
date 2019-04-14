package br.com.lucas.gestorfinanceiroapi.util;

public interface AppConstantes {

	// REST
	String PATH_DESPESAS = "/despesas";
	
	String PATH_CATEGORIAS = "/categoria";
	
	String PATH_CONTAS = "/conta";

	String PATH_LISTAR = "/listar";

	String PATH_FUNCIONARIOS = "/funcionarios";

	String PATH_GRUPO_EMPRESAS = "/grupos-empresas";

	String PATH_SUBGRUPO_EMPRESAS = "/subgrupos-empresas";

	String PATH_ESTABELECIMENTOS = "/estabelecimentos";

	String PATH_BLACKLIST_PALAVRAS = "/blacklistpalavras";

	String PATH_VALIDAR = "/validar";

	String PATH_ID = "/{id}";

	String PATH_PERMISSOES_USUARIOS_EC = "/ec/permissoes";

	String PATH_PERMISSOES_GRUPO_ESTABELECIMENTOS = "/permissoes-gruposestabelecimentos";

	String PATH_PERMISSOES_ESTABELECIMENTOS = "/permissoes-estabelecimentos";

	String PATH_EMPRESAS = "/empresas";

	String PATH_CARTOES = "/cartoes";

	String PATH_CARTOES_NOTIFICACOES_APN = "/{id}/apnsubscriptions";

	String PATH_NOTIFICACOES_APN = "/apnsubscriptions";

	String PATH_ESTABELECIMENTOS_HORARIOS = "/horarios";

	String PATH_CARTOES_VALIDAR_SENHA = "/{id}/senhas";

	String PATH_FUNCIONARIOS_PRODUTOS = "/funcionariosprodutos";

	String PATH_GRUPOS_ECONOMICOS = "/grupos-economicos";

	String PATH_CARGAS = "/cargas";

	String PATH_ID_CARGAS = "/{id}/cargas";

	String PATH_HISTORICO_PEDIDOS = "/cargas/{idCargaBeneficio}/empresas";

	String PATH_FUNCIONARIOS_PRODUTOS_CARGAS = "/{id}/cargas";

	String PATH_ESTABELECIMENTO_HORARIO = "/estabelecimentos/{id}/horarios";

	String PATH_ESTABELECIMENTO_PRODUTO = "/{id}/produtos";

	String PATH_CONTAS_EXTRATO = "/{id}/extratos";

	String PATH_PARAMETROS_GRUPOS_EMPRESAS = PATH_GRUPO_EMPRESAS + "/{idGrupoEmpresa}/parametros";

	String PATH_PARAMETROS = "/parametros/{codigo}";

	String PATH_PERFIS = "/perfis-acesso";

	String PATH_USUARIOS = "/usuarios";

	String PATH_ESTABELECIMENTOS_TAXAS = "/estabelecimentos/{id}/taxas";

	String PATH_VALIDAR_ESTABELECIMENTOS = "/validar-dados-iniciais";

	String PATH_PIER_NOTIFICACOES_SMS = "/notificacoes-sms";

	String PATH_PIER_CODIGOS_SEGURANCA_ENVIAR = PATH_PIER_NOTIFICACOES_SMS + "/gerar-codigo-seguranca";

	String PATH_PIER_CODIGOS_SEGURANCA_VALIDAR = PATH_PIER_NOTIFICACOES_SMS + "/validar-codigo-seguranca";

	String PATH_PIER_CODIGOS_SEGURANCA_REENVIAR = PATH_PIER_NOTIFICACOES_SMS + "/reenviar-codigo-seguranca";

	String PATH_TOKENS = "/tokens";

	String PATH_SOCIOS = "/socios";

	String PATH_FERIADOS = "/feriados";

	String PATH_PERMISSOES_RH = "/rh/permissoes";

	String PATH_PUSH_NOTIFICATIONS = "/notificacoes";

	String PATH_USUARIOS_OPERACAO = "/operacoes";

	String PATH_PERMISSOES_OPERACAO = "/operacoes";

	String PATH_PERMISSOES_OPERACOES_RH = "/rh/permissoes/{id}/operacoes";

	String PATH_EC_USUARIOS = "/ec/usuarios";

	String PATH_CARTOES_RASTREAMENTO = "/{id}/rastreamentos";

	String PATH_PERMISSOES = "/rh/permissoes";

	String PATH_OPERACOES = "/operacoes";

	String PATH_USUARIOS_ACESSO_RH = "/acessos";

	String PATH_CNAES = "/cnaes";

	// RABBITMQ
	String AMQP_ECFINDER_E = "blue.ecfinder.estabelecimento.E";

	String AMQP_ECFINDER_Q = "blue.ecfinder.estabelecimento.Q";

	String AMQP_ECFINDER_DLX = "blue.ecfinder.estabelecimento.DLX";

	String AMQP_ECFINDER_DLQ = "blue.ecfinder.estabelecimento.DLQ";

	String EXCHANGE_BLUE_API = "blue.blueapi.exchange";

	String EXCHANGE_ESTABELECIMENTO_CNAE = "blue.blueapi.exchange.estabelecimento";

	String QUEUE_BLUE_SOCIO_USUARIO = "blue.blueapi.cadastro_socio_usuario.QUEUE";

	String QUEUE_BLUE_ESTABELECIMENTO_CNAE = "blue.blueapi.estabelecimento.QUEUE.ecfinder";

	String ROUTING_KEY_NAME_SOCIO_USUARIO = "blue.blueapi.cadastro_socio_usuario*";

	String ROUTING_KEY_NAME_ESTABELECIMENTOS = "blue.blueapi.estabelecimento.QUEUE.*";

	String DEAD_LETTER_SOCIO_USUARIO_QUEUE = "blue.blueapi.cadastro_socio_usuario.dead-letter.queue";

	String DEAD_LETTER_BLUE_ESTABELECIMENTO_QUEUE = "blue.blueapi.estabelecimento.ecfinder.DLQ";

	String DLX_SOCIO_USUARIO_QUEUE = "blue.blueapi.cadastro_socio_usuario.dlx";

	String DLX_ESTABELECIMENTO = "blue.blueapi.estabelecimento.dlx";

}
