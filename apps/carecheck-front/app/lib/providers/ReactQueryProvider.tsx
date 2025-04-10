"use client";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import type * as React from "react";
import { customInstance } from "../axios-client/customClient";

// Create a client
const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      queryFn: async ({ queryKey }) => {
        const [url, params] = queryKey; // 쿼리 키로 URL과 params 전달
        return customInstance({
          url: url as string,
          params: params as Record<string, any>, // 파라미터 전달
        });
      },
      retry: false, // 재시도 기본값: false
      refetchOnWindowFocus: false, // 포커스 시 재요청 비활성화
    },
  },
});

export default function Providers({ children }: { children: React.ReactNode }) {
  return (
    <QueryClientProvider client={queryClient}>{children}</QueryClientProvider>
  );
}