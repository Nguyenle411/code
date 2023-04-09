# Tên : Nguyễn Hoàng Thái
# MSSV: 20009931

import pandas as pd
import numpy as np 
import matplotlib.pyplot as plt
import scipy.stats as st
from scipy.stats import norm

# bài 1 
data = pd.read_excel('D:\\Thong ke may tinh va ung dung\\DataSet\\18_M&M.xls')
print(data)
df = pd.DataFrame( data, columns=[  'Red',  'Orange',  'Yellow',  'Brown',   'Blue',  'Green'])
# n: kích thước mẫu kẹo có màu xanh lá
n = df['Green'].count()
# N: kích thước mẫu kẹo có màu bất kì
N = df['Blue'].count() + df['Red'].count() + df['Orange'].count() + df['Yellow'].count() + df['Green'].count()
print('Tỉ lệ là: ', n/N )
p_mu = n/N
q_mu = 1 - p_mu
z_alpha_chia2 = (-1)*st.norm.ppf(.025, 0.1)
print('Z_alpha_chia2: ', z_alpha_chia2 )
e = z_alpha_chia2*np.sqrt(p_mu*q_mu)
print('Lỗi là: ', e )
print('Khoảng tin cậy là: ', p_mu-q_mu)
