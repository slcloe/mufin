'use client';

import { useSession } from 'next-auth/react';

type dataType = {
  data?: any;
  api: string;
};

const useFetch = () => {
  const { data: session } = useSession();

  const usePostFetch = async (data: dataType) => {
    const res = await fetch(
      `${process.env.NEXT_PUBLIC_BASE_URL}/api${data.api}`,
      {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          Authorization: `${session?.Authorization}`,
        },
        body: JSON.stringify(data.data),
      },
    );
    return res.json();
  };

  const useGetFetch = async (data: dataType) => {
    const res = await fetch(
      `${process.env.NEXT_PUBLIC_BASE_URL}/api${data.api}`,
      {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
          Authorization: `${session?.Authorization}`,
        },
      },
    );
    return res.json();
  };

  return { usePostFetch, useGetFetch };
};

export default useFetch;
