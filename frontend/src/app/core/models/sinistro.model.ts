export interface Sinistro {
  id: number;
  numero: string;
  descricao: string;
  status: 'ABERTO' | 'APROVADO' | 'EM_ANALISE' | 'NEGADO' | 'PAGO' | 'REJEITADO';
  valor_solicitado: number;
  data_abertura: string;
  apolice_id: number;
}