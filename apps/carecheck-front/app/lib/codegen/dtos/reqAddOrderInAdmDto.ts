/**
 * Generated by orval v7.8.0 🍺
 * Do not edit manually.
 * carecheck
 * api 문서
 * OpenAPI spec version: 1.0.0
 */

export interface ReqAddOrderInAdmDto {
  /** 접수번호 */
  admId: number;
  /** 오더코드 */
  orderCode: string;
  /** 용량ml, mg */
  orderDose: number;
  /** 횟수 */
  orderCount: number;
  /** 일수 */
  orderDays: number;
  /** 방법 */
  orderMethod?: string;
}
