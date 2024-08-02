import React from 'react'
import { Link } from 'react-router-dom';
function Login() {



  return (
   <>
  <div className='flex self-center justify-center rounded-lg z-10 mt-20'>
    <div className=' p-12 bg-slate-300 rounded-2xl mx-auto w-100'>
      <div className='mb-3 text-left' >
        <h3 className='text-2xl  font-semibold text-gray-800' >Sign In</h3>
        <p className='text-gray-700'>Please Sign in to your Account</p>
      </div>

      <div className='space-y-5 text-left'>
        <div className='space-y-2 ' >
          <label className='p-3 text-lg font-medium tracking-wide ' htmlFor="">Email</label>
          <input className='w-full text-base px-4 py-2 border-gray-300 rounded-lg focus:outline-none focus:border-black' type="text" placeholder='mail@gmail.com' />
        </div>

        <div className='space-y-2'>
          <label className='p-3 font-medium text-lg tracking-wide' htmlFor="">Password</label>
          <input className='w-full text-base px-4 py-2 border-gray-300 rounded-lg focus:outline-none focus:border-black' type="text" placeholder='Enter your password'/>
        </div>

        <div className='flex self-center justify-between' >
            <div className='flex items-center' >
              <input className='h-4' type="checkbox" />
              <label className='ml-2 text-sm text-gray-700' htmlFor="">Remember me</label>
            </div>
            <div className='text-sm' >
              <Link>
                Forget your password?
              </Link>
            </div>
        </div>
        <div>
          <button className=' bg-white w-full p-3 text-lg text-black flex justify-center hover:bg-gray-400 rounded-full tracking-wide font-semibold shadow-lg cursor-pointer transition ease-in duration-300' >Sign in</button>
        </div>

      </div>
    </div>
  </div>
   </>
  )
}

export default Login
