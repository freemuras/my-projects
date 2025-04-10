/**
 * Generated by orval v7.8.0 🍺
 * Do not edit manually.
 * carecheck
 * api 문서
 * OpenAPI spec version: 1.0.0
 */
import {
  useInfiniteQuery,
  useQuery
} from '@tanstack/react-query';
import type {
  DataTag,
  DefinedInitialDataOptions,
  DefinedUseInfiniteQueryResult,
  DefinedUseQueryResult,
  InfiniteData,
  QueryClient,
  QueryFunction,
  QueryKey,
  UndefinedInitialDataOptions,
  UseInfiniteQueryOptions,
  UseInfiniteQueryResult,
  UseQueryOptions,
  UseQueryResult
} from '@tanstack/react-query';

import type {
  SelectUsercodeByRoleId200,
  SelectUsercodeByRoleIdParams
} from '../../dtos';

import { customInstance } from '../../../axios-client/customClient';
import type { ErrorType } from '../../../axios-client/customClient';


type SecondParameter<T extends (...args: never) => unknown> = Parameters<T>[1];



/**
 * 권한id입력으로 usercode, name 조회
 * @summary 권한id로 의사코드, 이름 조회.
 */
export const selectUsercodeByRoleId = (
    params: SelectUsercodeByRoleIdParams,
 options?: SecondParameter<typeof customInstance>,signal?: AbortSignal
) => {
      
      
      return customInstance<SelectUsercodeByRoleId200>(
      {url: `/api/roles`, method: 'GET',
        params, signal
    },
      options);
    }
  

export const getSelectUsercodeByRoleIdQueryKey = (params: SelectUsercodeByRoleIdParams,) => {
    return [`/api/roles`, ...(params ? [params]: [])] as const;
    }

    
export const getSelectUsercodeByRoleIdInfiniteQueryOptions = <TData = InfiniteData<Awaited<ReturnType<typeof selectUsercodeByRoleId>>>, TError = ErrorType<unknown>>(params: SelectUsercodeByRoleIdParams, options?: { query?:Partial<UseInfiniteQueryOptions<Awaited<ReturnType<typeof selectUsercodeByRoleId>>, TError, TData>>, request?: SecondParameter<typeof customInstance>}
) => {

const {query: queryOptions, request: requestOptions} = options ?? {};

  const queryKey =  queryOptions?.queryKey ?? getSelectUsercodeByRoleIdQueryKey(params);

  

    const queryFn: QueryFunction<Awaited<ReturnType<typeof selectUsercodeByRoleId>>> = ({ signal }) => selectUsercodeByRoleId(params, requestOptions, signal);

      

      

   return  { queryKey, queryFn, ...queryOptions} as UseInfiniteQueryOptions<Awaited<ReturnType<typeof selectUsercodeByRoleId>>, TError, TData> & { queryKey: DataTag<QueryKey, TData, TError> }
}

export type SelectUsercodeByRoleIdInfiniteQueryResult = NonNullable<Awaited<ReturnType<typeof selectUsercodeByRoleId>>>
export type SelectUsercodeByRoleIdInfiniteQueryError = ErrorType<unknown>


export function useSelectUsercodeByRoleIdInfinite<TData = InfiniteData<Awaited<ReturnType<typeof selectUsercodeByRoleId>>>, TError = ErrorType<unknown>>(
 params: SelectUsercodeByRoleIdParams, options: { query:Partial<UseInfiniteQueryOptions<Awaited<ReturnType<typeof selectUsercodeByRoleId>>, TError, TData>> & Pick<
        DefinedInitialDataOptions<
          Awaited<ReturnType<typeof selectUsercodeByRoleId>>,
          TError,
          Awaited<ReturnType<typeof selectUsercodeByRoleId>>
        > , 'initialData'
      >, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient
  ):  DefinedUseInfiniteQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> }
export function useSelectUsercodeByRoleIdInfinite<TData = InfiniteData<Awaited<ReturnType<typeof selectUsercodeByRoleId>>>, TError = ErrorType<unknown>>(
 params: SelectUsercodeByRoleIdParams, options?: { query?:Partial<UseInfiniteQueryOptions<Awaited<ReturnType<typeof selectUsercodeByRoleId>>, TError, TData>> & Pick<
        UndefinedInitialDataOptions<
          Awaited<ReturnType<typeof selectUsercodeByRoleId>>,
          TError,
          Awaited<ReturnType<typeof selectUsercodeByRoleId>>
        > , 'initialData'
      >, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient
  ):  UseInfiniteQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> }
export function useSelectUsercodeByRoleIdInfinite<TData = InfiniteData<Awaited<ReturnType<typeof selectUsercodeByRoleId>>>, TError = ErrorType<unknown>>(
 params: SelectUsercodeByRoleIdParams, options?: { query?:Partial<UseInfiniteQueryOptions<Awaited<ReturnType<typeof selectUsercodeByRoleId>>, TError, TData>>, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient
  ):  UseInfiniteQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> }
/**
 * @summary 권한id로 의사코드, 이름 조회.
 */

export function useSelectUsercodeByRoleIdInfinite<TData = InfiniteData<Awaited<ReturnType<typeof selectUsercodeByRoleId>>>, TError = ErrorType<unknown>>(
 params: SelectUsercodeByRoleIdParams, options?: { query?:Partial<UseInfiniteQueryOptions<Awaited<ReturnType<typeof selectUsercodeByRoleId>>, TError, TData>>, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient 
 ):  UseInfiniteQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> } {

  const queryOptions = getSelectUsercodeByRoleIdInfiniteQueryOptions(params,options)

  const query = useInfiniteQuery(queryOptions , queryClient) as  UseInfiniteQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> };

  query.queryKey = queryOptions.queryKey ;

  return query;
}



export const getSelectUsercodeByRoleIdQueryOptions = <TData = Awaited<ReturnType<typeof selectUsercodeByRoleId>>, TError = ErrorType<unknown>>(params: SelectUsercodeByRoleIdParams, options?: { query?:Partial<UseQueryOptions<Awaited<ReturnType<typeof selectUsercodeByRoleId>>, TError, TData>>, request?: SecondParameter<typeof customInstance>}
) => {

const {query: queryOptions, request: requestOptions} = options ?? {};

  const queryKey =  queryOptions?.queryKey ?? getSelectUsercodeByRoleIdQueryKey(params);

  

    const queryFn: QueryFunction<Awaited<ReturnType<typeof selectUsercodeByRoleId>>> = ({ signal }) => selectUsercodeByRoleId(params, requestOptions, signal);

      

      

   return  { queryKey, queryFn, ...queryOptions} as UseQueryOptions<Awaited<ReturnType<typeof selectUsercodeByRoleId>>, TError, TData> & { queryKey: DataTag<QueryKey, TData, TError> }
}

export type SelectUsercodeByRoleIdQueryResult = NonNullable<Awaited<ReturnType<typeof selectUsercodeByRoleId>>>
export type SelectUsercodeByRoleIdQueryError = ErrorType<unknown>


export function useSelectUsercodeByRoleId<TData = Awaited<ReturnType<typeof selectUsercodeByRoleId>>, TError = ErrorType<unknown>>(
 params: SelectUsercodeByRoleIdParams, options: { query:Partial<UseQueryOptions<Awaited<ReturnType<typeof selectUsercodeByRoleId>>, TError, TData>> & Pick<
        DefinedInitialDataOptions<
          Awaited<ReturnType<typeof selectUsercodeByRoleId>>,
          TError,
          Awaited<ReturnType<typeof selectUsercodeByRoleId>>
        > , 'initialData'
      >, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient
  ):  DefinedUseQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> }
export function useSelectUsercodeByRoleId<TData = Awaited<ReturnType<typeof selectUsercodeByRoleId>>, TError = ErrorType<unknown>>(
 params: SelectUsercodeByRoleIdParams, options?: { query?:Partial<UseQueryOptions<Awaited<ReturnType<typeof selectUsercodeByRoleId>>, TError, TData>> & Pick<
        UndefinedInitialDataOptions<
          Awaited<ReturnType<typeof selectUsercodeByRoleId>>,
          TError,
          Awaited<ReturnType<typeof selectUsercodeByRoleId>>
        > , 'initialData'
      >, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient
  ):  UseQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> }
export function useSelectUsercodeByRoleId<TData = Awaited<ReturnType<typeof selectUsercodeByRoleId>>, TError = ErrorType<unknown>>(
 params: SelectUsercodeByRoleIdParams, options?: { query?:Partial<UseQueryOptions<Awaited<ReturnType<typeof selectUsercodeByRoleId>>, TError, TData>>, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient
  ):  UseQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> }
/**
 * @summary 권한id로 의사코드, 이름 조회.
 */

export function useSelectUsercodeByRoleId<TData = Awaited<ReturnType<typeof selectUsercodeByRoleId>>, TError = ErrorType<unknown>>(
 params: SelectUsercodeByRoleIdParams, options?: { query?:Partial<UseQueryOptions<Awaited<ReturnType<typeof selectUsercodeByRoleId>>, TError, TData>>, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient 
 ):  UseQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> } {

  const queryOptions = getSelectUsercodeByRoleIdQueryOptions(params,options)

  const query = useQuery(queryOptions , queryClient) as  UseQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> };

  query.queryKey = queryOptions.queryKey ;

  return query;
}



