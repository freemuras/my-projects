/**
 * Generated by orval v7.8.0 🍺
 * Do not edit manually.
 * carecheck
 * api 문서
 * OpenAPI spec version: 1.0.0
 */
import {
  useInfiniteQuery,
  useMutation,
  useQuery
} from '@tanstack/react-query';
import type {
  DataTag,
  DefinedInitialDataOptions,
  DefinedUseInfiniteQueryResult,
  DefinedUseQueryResult,
  InfiniteData,
  MutationFunction,
  QueryClient,
  QueryFunction,
  QueryKey,
  UndefinedInitialDataOptions,
  UseInfiniteQueryOptions,
  UseInfiniteQueryResult,
  UseMutationOptions,
  UseMutationResult,
  UseQueryOptions,
  UseQueryResult
} from '@tanstack/react-query';

import type {
  ChangeEmail200,
  ChangeEmailBody,
  ChangePassword200,
  ChangePasswordBody,
  ChangePhoneNumber200,
  ChangePhoneNumberBody,
  GetLoginUser200
} from '../../dtos';

import { customInstance } from '../../../axios-client/customClient';
import type { ErrorType , BodyType } from '../../../axios-client/customClient';


type SecondParameter<T extends (...args: never) => unknown> = Parameters<T>[1];



/**
 * 내 정보 화면 - 전화번호 수정
 * @summary 개인 정보 수정(전화번호)
 */
export const changePhoneNumber = (
    changePhoneNumberBody: BodyType<ChangePhoneNumberBody>,
 options?: SecondParameter<typeof customInstance>,) => {
      
      
      return customInstance<ChangePhoneNumber200>(
      {url: `/api/account/users/phone-number`, method: 'PUT',
      headers: {'Content-Type': 'application/json', },
      data: changePhoneNumberBody
    },
      options);
    }
  


export const getChangePhoneNumberMutationOptions = <TError = ErrorType<unknown>,
    TContext = unknown>(options?: { mutation?:UseMutationOptions<Awaited<ReturnType<typeof changePhoneNumber>>, TError,{data: BodyType<ChangePhoneNumberBody>}, TContext>, request?: SecondParameter<typeof customInstance>}
): UseMutationOptions<Awaited<ReturnType<typeof changePhoneNumber>>, TError,{data: BodyType<ChangePhoneNumberBody>}, TContext> => {
    
const mutationKey = ['changePhoneNumber'];
const {mutation: mutationOptions, request: requestOptions} = options ?
      options.mutation && 'mutationKey' in options.mutation && options.mutation.mutationKey ?
      options
      : {...options, mutation: {...options.mutation, mutationKey}}
      : {mutation: { mutationKey, }, request: undefined};

      


      const mutationFn: MutationFunction<Awaited<ReturnType<typeof changePhoneNumber>>, {data: BodyType<ChangePhoneNumberBody>}> = (props) => {
          const {data} = props ?? {};

          return  changePhoneNumber(data,requestOptions)
        }

        


  return  { mutationFn, ...mutationOptions }}

    export type ChangePhoneNumberMutationResult = NonNullable<Awaited<ReturnType<typeof changePhoneNumber>>>
    export type ChangePhoneNumberMutationBody = BodyType<ChangePhoneNumberBody>
    export type ChangePhoneNumberMutationError = ErrorType<unknown>

    /**
 * @summary 개인 정보 수정(전화번호)
 */
export const useChangePhoneNumber = <TError = ErrorType<unknown>,
    TContext = unknown>(options?: { mutation?:UseMutationOptions<Awaited<ReturnType<typeof changePhoneNumber>>, TError,{data: BodyType<ChangePhoneNumberBody>}, TContext>, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient): UseMutationResult<
        Awaited<ReturnType<typeof changePhoneNumber>>,
        TError,
        {data: BodyType<ChangePhoneNumberBody>},
        TContext
      > => {

      const mutationOptions = getChangePhoneNumberMutationOptions(options);

      return useMutation(mutationOptions , queryClient);
    }
    /**
 * 내 정보 화면 - 비밀번호 수정
 * @summary 개인 정보 수정(비밀번호)
 */
export const changePassword = (
    changePasswordBody: BodyType<ChangePasswordBody>,
 options?: SecondParameter<typeof customInstance>,) => {
      
      
      return customInstance<ChangePassword200>(
      {url: `/api/account/users/password`, method: 'PUT',
      headers: {'Content-Type': 'application/json', },
      data: changePasswordBody
    },
      options);
    }
  


export const getChangePasswordMutationOptions = <TError = ErrorType<unknown>,
    TContext = unknown>(options?: { mutation?:UseMutationOptions<Awaited<ReturnType<typeof changePassword>>, TError,{data: BodyType<ChangePasswordBody>}, TContext>, request?: SecondParameter<typeof customInstance>}
): UseMutationOptions<Awaited<ReturnType<typeof changePassword>>, TError,{data: BodyType<ChangePasswordBody>}, TContext> => {
    
const mutationKey = ['changePassword'];
const {mutation: mutationOptions, request: requestOptions} = options ?
      options.mutation && 'mutationKey' in options.mutation && options.mutation.mutationKey ?
      options
      : {...options, mutation: {...options.mutation, mutationKey}}
      : {mutation: { mutationKey, }, request: undefined};

      


      const mutationFn: MutationFunction<Awaited<ReturnType<typeof changePassword>>, {data: BodyType<ChangePasswordBody>}> = (props) => {
          const {data} = props ?? {};

          return  changePassword(data,requestOptions)
        }

        


  return  { mutationFn, ...mutationOptions }}

    export type ChangePasswordMutationResult = NonNullable<Awaited<ReturnType<typeof changePassword>>>
    export type ChangePasswordMutationBody = BodyType<ChangePasswordBody>
    export type ChangePasswordMutationError = ErrorType<unknown>

    /**
 * @summary 개인 정보 수정(비밀번호)
 */
export const useChangePassword = <TError = ErrorType<unknown>,
    TContext = unknown>(options?: { mutation?:UseMutationOptions<Awaited<ReturnType<typeof changePassword>>, TError,{data: BodyType<ChangePasswordBody>}, TContext>, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient): UseMutationResult<
        Awaited<ReturnType<typeof changePassword>>,
        TError,
        {data: BodyType<ChangePasswordBody>},
        TContext
      > => {

      const mutationOptions = getChangePasswordMutationOptions(options);

      return useMutation(mutationOptions , queryClient);
    }
    /**
 * 내 정보 화면 - 이메일 수정
 * @summary 개인 정보 수정(이메일)
 */
export const changeEmail = (
    changeEmailBody: BodyType<ChangeEmailBody>,
 options?: SecondParameter<typeof customInstance>,) => {
      
      
      return customInstance<ChangeEmail200>(
      {url: `/api/account/users/email`, method: 'PUT',
      headers: {'Content-Type': 'application/json', },
      data: changeEmailBody
    },
      options);
    }
  


export const getChangeEmailMutationOptions = <TError = ErrorType<unknown>,
    TContext = unknown>(options?: { mutation?:UseMutationOptions<Awaited<ReturnType<typeof changeEmail>>, TError,{data: BodyType<ChangeEmailBody>}, TContext>, request?: SecondParameter<typeof customInstance>}
): UseMutationOptions<Awaited<ReturnType<typeof changeEmail>>, TError,{data: BodyType<ChangeEmailBody>}, TContext> => {
    
const mutationKey = ['changeEmail'];
const {mutation: mutationOptions, request: requestOptions} = options ?
      options.mutation && 'mutationKey' in options.mutation && options.mutation.mutationKey ?
      options
      : {...options, mutation: {...options.mutation, mutationKey}}
      : {mutation: { mutationKey, }, request: undefined};

      


      const mutationFn: MutationFunction<Awaited<ReturnType<typeof changeEmail>>, {data: BodyType<ChangeEmailBody>}> = (props) => {
          const {data} = props ?? {};

          return  changeEmail(data,requestOptions)
        }

        


  return  { mutationFn, ...mutationOptions }}

    export type ChangeEmailMutationResult = NonNullable<Awaited<ReturnType<typeof changeEmail>>>
    export type ChangeEmailMutationBody = BodyType<ChangeEmailBody>
    export type ChangeEmailMutationError = ErrorType<unknown>

    /**
 * @summary 개인 정보 수정(이메일)
 */
export const useChangeEmail = <TError = ErrorType<unknown>,
    TContext = unknown>(options?: { mutation?:UseMutationOptions<Awaited<ReturnType<typeof changeEmail>>, TError,{data: BodyType<ChangeEmailBody>}, TContext>, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient): UseMutationResult<
        Awaited<ReturnType<typeof changeEmail>>,
        TError,
        {data: BodyType<ChangeEmailBody>},
        TContext
      > => {

      const mutationOptions = getChangeEmailMutationOptions(options);

      return useMutation(mutationOptions , queryClient);
    }
    /**
 * 로그인 유저 정보 불러오기
 * @summary 로그인 유저 정보
 */
export const getLoginUser = (
    
 options?: SecondParameter<typeof customInstance>,signal?: AbortSignal
) => {
      
      
      return customInstance<GetLoginUser200>(
      {url: `/api/account/users/me`, method: 'GET', signal
    },
      options);
    }
  

export const getGetLoginUserQueryKey = () => {
    return [`/api/account/users/me`] as const;
    }

    
export const getGetLoginUserInfiniteQueryOptions = <TData = InfiniteData<Awaited<ReturnType<typeof getLoginUser>>>, TError = ErrorType<unknown>>( options?: { query?:Partial<UseInfiniteQueryOptions<Awaited<ReturnType<typeof getLoginUser>>, TError, TData>>, request?: SecondParameter<typeof customInstance>}
) => {

const {query: queryOptions, request: requestOptions} = options ?? {};

  const queryKey =  queryOptions?.queryKey ?? getGetLoginUserQueryKey();

  

    const queryFn: QueryFunction<Awaited<ReturnType<typeof getLoginUser>>> = ({ signal }) => getLoginUser(requestOptions, signal);

      

      

   return  { queryKey, queryFn, ...queryOptions} as UseInfiniteQueryOptions<Awaited<ReturnType<typeof getLoginUser>>, TError, TData> & { queryKey: DataTag<QueryKey, TData, TError> }
}

export type GetLoginUserInfiniteQueryResult = NonNullable<Awaited<ReturnType<typeof getLoginUser>>>
export type GetLoginUserInfiniteQueryError = ErrorType<unknown>


export function useGetLoginUserInfinite<TData = InfiniteData<Awaited<ReturnType<typeof getLoginUser>>>, TError = ErrorType<unknown>>(
  options: { query:Partial<UseInfiniteQueryOptions<Awaited<ReturnType<typeof getLoginUser>>, TError, TData>> & Pick<
        DefinedInitialDataOptions<
          Awaited<ReturnType<typeof getLoginUser>>,
          TError,
          Awaited<ReturnType<typeof getLoginUser>>
        > , 'initialData'
      >, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient
  ):  DefinedUseInfiniteQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> }
export function useGetLoginUserInfinite<TData = InfiniteData<Awaited<ReturnType<typeof getLoginUser>>>, TError = ErrorType<unknown>>(
  options?: { query?:Partial<UseInfiniteQueryOptions<Awaited<ReturnType<typeof getLoginUser>>, TError, TData>> & Pick<
        UndefinedInitialDataOptions<
          Awaited<ReturnType<typeof getLoginUser>>,
          TError,
          Awaited<ReturnType<typeof getLoginUser>>
        > , 'initialData'
      >, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient
  ):  UseInfiniteQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> }
export function useGetLoginUserInfinite<TData = InfiniteData<Awaited<ReturnType<typeof getLoginUser>>>, TError = ErrorType<unknown>>(
  options?: { query?:Partial<UseInfiniteQueryOptions<Awaited<ReturnType<typeof getLoginUser>>, TError, TData>>, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient
  ):  UseInfiniteQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> }
/**
 * @summary 로그인 유저 정보
 */

export function useGetLoginUserInfinite<TData = InfiniteData<Awaited<ReturnType<typeof getLoginUser>>>, TError = ErrorType<unknown>>(
  options?: { query?:Partial<UseInfiniteQueryOptions<Awaited<ReturnType<typeof getLoginUser>>, TError, TData>>, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient 
 ):  UseInfiniteQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> } {

  const queryOptions = getGetLoginUserInfiniteQueryOptions(options)

  const query = useInfiniteQuery(queryOptions , queryClient) as  UseInfiniteQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> };

  query.queryKey = queryOptions.queryKey ;

  return query;
}



export const getGetLoginUserQueryOptions = <TData = Awaited<ReturnType<typeof getLoginUser>>, TError = ErrorType<unknown>>( options?: { query?:Partial<UseQueryOptions<Awaited<ReturnType<typeof getLoginUser>>, TError, TData>>, request?: SecondParameter<typeof customInstance>}
) => {

const {query: queryOptions, request: requestOptions} = options ?? {};

  const queryKey =  queryOptions?.queryKey ?? getGetLoginUserQueryKey();

  

    const queryFn: QueryFunction<Awaited<ReturnType<typeof getLoginUser>>> = ({ signal }) => getLoginUser(requestOptions, signal);

      

      

   return  { queryKey, queryFn, ...queryOptions} as UseQueryOptions<Awaited<ReturnType<typeof getLoginUser>>, TError, TData> & { queryKey: DataTag<QueryKey, TData, TError> }
}

export type GetLoginUserQueryResult = NonNullable<Awaited<ReturnType<typeof getLoginUser>>>
export type GetLoginUserQueryError = ErrorType<unknown>


export function useGetLoginUser<TData = Awaited<ReturnType<typeof getLoginUser>>, TError = ErrorType<unknown>>(
  options: { query:Partial<UseQueryOptions<Awaited<ReturnType<typeof getLoginUser>>, TError, TData>> & Pick<
        DefinedInitialDataOptions<
          Awaited<ReturnType<typeof getLoginUser>>,
          TError,
          Awaited<ReturnType<typeof getLoginUser>>
        > , 'initialData'
      >, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient
  ):  DefinedUseQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> }
export function useGetLoginUser<TData = Awaited<ReturnType<typeof getLoginUser>>, TError = ErrorType<unknown>>(
  options?: { query?:Partial<UseQueryOptions<Awaited<ReturnType<typeof getLoginUser>>, TError, TData>> & Pick<
        UndefinedInitialDataOptions<
          Awaited<ReturnType<typeof getLoginUser>>,
          TError,
          Awaited<ReturnType<typeof getLoginUser>>
        > , 'initialData'
      >, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient
  ):  UseQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> }
export function useGetLoginUser<TData = Awaited<ReturnType<typeof getLoginUser>>, TError = ErrorType<unknown>>(
  options?: { query?:Partial<UseQueryOptions<Awaited<ReturnType<typeof getLoginUser>>, TError, TData>>, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient
  ):  UseQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> }
/**
 * @summary 로그인 유저 정보
 */

export function useGetLoginUser<TData = Awaited<ReturnType<typeof getLoginUser>>, TError = ErrorType<unknown>>(
  options?: { query?:Partial<UseQueryOptions<Awaited<ReturnType<typeof getLoginUser>>, TError, TData>>, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient 
 ):  UseQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> } {

  const queryOptions = getGetLoginUserQueryOptions(options)

  const query = useQuery(queryOptions , queryClient) as  UseQueryResult<TData, TError> & { queryKey: DataTag<QueryKey, TData, TError> };

  query.queryKey = queryOptions.queryKey ;

  return query;
}



