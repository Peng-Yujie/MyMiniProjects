import { createClient } from "@supabase/supabase-js";

export const supabaseUrl = "https://leswijvlebvuyxufjlwo.supabase.co";
const supabaseKey =
  "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imxlc3dpanZsZWJ2dXl4dWZqbHdvIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTQxNDgzNzIsImV4cCI6MjAyOTcyNDM3Mn0.RM0bZjtxFs2pzsq5RSetRlX42uasTff34cpf9nQZyxg";
const supabase = createClient(supabaseUrl, supabaseKey);

export default supabase;
