/**
 * Generated by orval v7.8.0 🍺
 * Do not edit manually.
 * carecheck
 * api 문서
 * OpenAPI spec version: 1.0.0
 */
import {
  useMutation
} from '@tanstack/react-query';
import type {
  MutationFunction,
  QueryClient,
  UseMutationOptions,
  UseMutationResult
} from '@tanstack/react-query';

import type {
  ReqSigninDto,
  Signin200
} from '../../dtos';

import { customInstance } from '../../../axios-client/customClient';
import type { ErrorType , BodyType } from '../../../axios-client/customClient';


type SecondParameter<T extends (...args: never) => unknown> = Parameters<T>[1];



/**
 * 로그인
 * @summary 로그인
 */
export const signin = (
    reqSigninDto: BodyType<ReqSigninDto>,
 options?: SecondParameter<typeof customInstance>,signal?: AbortSignal
) => {
      
      
      return customInstance<Signin200>(
      {url: `/api/auth/signin`, method: 'POST',
      headers: {'Content-Type': 'application/json', },
      data: reqSigninDto, signal
    },
      options);
    }
  


export const getSigninMutationOptions = <TError = ErrorType<unknown>,
    TContext = unknown>(options?: { mutation?:UseMutationOptions<Awaited<ReturnType<typeof signin>>, TError,{data: BodyType<ReqSigninDto>}, TContext>, request?: SecondParameter<typeof customInstance>}
): UseMutationOptions<Awaited<ReturnType<typeof signin>>, TError,{data: BodyType<ReqSigninDto>}, TContext> => {
    
const mutationKey = ['signin'];
const {mutation: mutationOptions, request: requestOptions} = options ?
      options.mutation && 'mutationKey' in options.mutation && options.mutation.mutationKey ?
      options
      : {...options, mutation: {...options.mutation, mutationKey}}
      : {mutation: { mutationKey, }, request: undefined};

      


      const mutationFn: MutationFunction<Awaited<ReturnType<typeof signin>>, {data: BodyType<ReqSigninDto>}> = (props) => {
          const {data} = props ?? {};

          return  signin(data,requestOptions)
        }

        


  return  { mutationFn, ...mutationOptions }}

    export type SigninMutationResult = NonNullable<Awaited<ReturnType<typeof signin>>>
    export type SigninMutationBody = BodyType<ReqSigninDto>
    export type SigninMutationError = ErrorType<unknown>

    /**
 * @summary 로그인
 */
export const useSignin = <TError = ErrorType<unknown>,
    TContext = unknown>(options?: { mutation?:UseMutationOptions<Awaited<ReturnType<typeof signin>>, TError,{data: BodyType<ReqSigninDto>}, TContext>, request?: SecondParameter<typeof customInstance>}
 , queryClient?: QueryClient): UseMutationResult<
        Awaited<ReturnType<typeof signin>>,
        TError,
        {data: BodyType<ReqSigninDto>},
        TContext
      > => {

      const mutationOptions = getSigninMutationOptions(options);

      return useMutation(mutationOptions , queryClient);
    }
    