import { defineConfig } from "orval";

export default defineConfig({
  carecheck: {
    input: "app/lib/codegen/schema.json", 
    output: {
      client: "react-query",
      target: "app/lib/codegen/hooks", 
      schemas: "app/lib/codegen/dtos",
      mode: "tags-split",
      prettier: true,

      override: {
        query: {
          useQuery: true,
          useInfinite: true,
          useMutation: true,
        },
        mutator: {
          path: "app/lib/axios-client/customClient.ts",
          name: "customInstance",
        },
      },
    },
  },
});
